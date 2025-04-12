package dev.bluemethyst.mods.toolsjs.items

// CREDIT TO https://github.com/BlakeBr0/Cucumber/blob/1.2!/src/main/java/com/blakebr0/cucumber/item/tool/BasePaxelItem.java

import dev.bluemethyst.mods.toolsjs.ModTags
import net.minecraft.advancements.CriteriaTriggers
import net.minecraft.server.level.ServerPlayer
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.DiggerItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Tier
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.block.CampfireBlock
import net.minecraft.world.level.block.state.BlockState
import net.neoforged.neoforge.common.ItemAbilities
import net.neoforged.neoforge.common.ItemAbility
import java.util.*
import java.util.function.Function

class BasePaxelItem @JvmOverloads constructor(
    tier: Tier,
    properties: Function<Properties?, Properties?> = Function { p: Properties? -> p }
) :
    DiggerItem(
        tier, ModTags.MINEABLE_WITH_PAXEL, properties.apply(
            Properties()
                .attributes(createAttributes(tier, 4.0f, -3.2f))
                .durability((tier.uses * 1.5).toInt())
        )!!
    ) {
    override fun canPerformAction(stack: ItemStack, ability: ItemAbility): Boolean {
        return ItemAbilities.DEFAULT_AXE_ACTIONS.contains(ability)
                || ItemAbilities.DEFAULT_PICKAXE_ACTIONS.contains(ability)
                || ItemAbilities.DEFAULT_SHOVEL_ACTIONS.contains(ability)
    }

    override fun useOn(context: UseOnContext): InteractionResult {
        // attempt to handle axe useOn functionality
        var result = tryAxeUseOn(context)

        // axe functionality did not apply
        if (result == InteractionResult.PASS) {
            // attempt to handle shovel useOn functionality
            result = tryShovelUseOn(context)
        }

        return result
    }

    companion object {
        private fun tryAxeUseOn(context: UseOnContext): InteractionResult {
            val level = context.level
            val pos = context.clickedPos
            val player = context.player
            val stack = context.itemInHand
            val state = level.getBlockState(pos)

            val axeStripped = Optional.ofNullable(state.getToolModifiedState(context, ItemAbilities.AXE_STRIP, false))
            val axeScraped = Optional.ofNullable(state.getToolModifiedState(context, ItemAbilities.AXE_SCRAPE, false))
            val axeWaxedOff = Optional.ofNullable(state.getToolModifiedState(context, ItemAbilities.AXE_WAX_OFF, false))

            var modifiedState = Optional.empty<BlockState>()

            if (axeStripped.isPresent) {
                level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0f, 1.0f)
                modifiedState = axeStripped
            } else if (axeScraped.isPresent) {
                level.playSound(player, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0f, 1.0f)
                level.levelEvent(player, 3005, pos, 0)
                modifiedState = axeScraped
            } else if (axeWaxedOff.isPresent) {
                level.playSound(player, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0f, 1.0f)
                level.levelEvent(player, 3004, pos, 0)
                modifiedState = axeWaxedOff
            }

            if (modifiedState.isPresent) {
                if (player is ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(player, pos, stack)
                }

                level.setBlock(pos, modifiedState.get(), 11)

                if (player != null) {
                    stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND)
                }

                return InteractionResult.sidedSuccess(level.isClientSide())
            }

            return InteractionResult.PASS
        }

        private fun tryShovelUseOn(context: UseOnContext): InteractionResult {
            val level = context.level
            val pos = context.clickedPos
            val player = context.player
            val stack = context.itemInHand
            val state = level.getBlockState(pos)

            val modifiedState = state.getToolModifiedState(context, ItemAbilities.SHOVEL_FLATTEN, false)
            var newState: BlockState? = null

            if (modifiedState != null && level.isEmptyBlock(pos.above())) {
                level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0f, 1.0f)
                newState = modifiedState
            } else if (state.block is CampfireBlock && state.getValue<Boolean>(CampfireBlock.LIT)) {
                if (!level.isClientSide()) {
                    level.levelEvent(null, 1009, pos, 0)
                }

                CampfireBlock.dowse(player, level, pos, state)

                newState = state.setValue(CampfireBlock.LIT, java.lang.Boolean.FALSE)
            }

            if (newState != null) {
                if (!level.isClientSide()) {
                    level.setBlock(pos, newState, 11)

                    if (player != null) {
                        stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND)
                    }
                }

                return InteractionResult.sidedSuccess(level.isClientSide())
            }

            return InteractionResult.PASS
        }
    }
}