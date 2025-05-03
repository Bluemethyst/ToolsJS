package dev.bluemethyst.mods.toolsjs

import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction
import net.minecraft.client.renderer.item.ItemProperties
import net.minecraft.core.component.DataComponents
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.*
import net.minecraft.world.item.component.ChargedProjectiles


object ModItemProperties {
    fun makeCustomBows(bow: Item) {

        ToolsJS.LOGGER.info("Resource location: ${ResourceLocation.withDefaultNamespace("pull")}")
        ToolsJS.LOGGER.info("Resource location: ${ResourceLocation.withDefaultNamespace("pulling")}")
        ItemProperties.register(
            bow,
            ResourceLocation.withDefaultNamespace("pull"),
            { p_344163_, p_344164_, p_344165_, p_344166_ ->
                if (p_344165_ == null) {
                    return@register 0.0f
                } else {
                    return@register if (p_344165_.getUseItem() !== p_344163_) 0.0f else (p_344163_.getUseDuration(
                        p_344165_
                    ) - p_344165_.getUseItemRemainingTicks()) / 20.0f
                }
            })

        ItemProperties.register(
            bow,
            ResourceLocation.withDefaultNamespace("pulling"),
            { p_174630_, p_174631_, p_174632_, p_174633_ -> if (p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() === p_174630_) 1.0f else 0.0f }
        )
    }

    fun makeCustomCrossbows(crossbow: Item) {
        ItemProperties.register(
            crossbow,
            ResourceLocation.withDefaultNamespace("pull"),
            { p_351682_: ItemStack?, p_351683_: ClientLevel?, p_351684_: LivingEntity?, p_351685_: Int ->
                if (p_351684_ == null) {
                    return@register 0.0f
                } else {
                    return@register if (CrossbowItem.isCharged(p_351682_))
                        0.0f
                    else
                        ((p_351682_!!.getUseDuration(p_351684_) - p_351684_.getUseItemRemainingTicks()).toFloat() / CrossbowItem.getChargeDuration(
                            p_351682_,
                            p_351684_
                        ).toFloat())
                }
            }
        )
        ItemProperties.register(
            crossbow,
            ResourceLocation.withDefaultNamespace("pulling"),
            ClampedItemPropertyFunction { p_174605_: ItemStack?, p_174606_: ClientLevel?, p_174607_: LivingEntity?, p_174608_: Int ->
                if (p_174607_ != null && p_174607_.isUsingItem()
                    && p_174607_.getUseItem() == p_174605_ && !CrossbowItem.isCharged(p_174605_)
                )
                    1.0f
                else
                    0.0f
            }
        )
        ItemProperties.register(
            crossbow,
            ResourceLocation.withDefaultNamespace("charged"),
            ClampedItemPropertyFunction { p_275891_: ItemStack?, p_275892_: ClientLevel?, p_275893_: LivingEntity?, p_275894_: Int ->
                if (CrossbowItem.isCharged(
                        p_275891_
                    )
                ) 1.0f else 0.0f
            }
        )
        ItemProperties.register(
            crossbow,
            ResourceLocation.withDefaultNamespace("firework"),
            ClampedItemPropertyFunction { p_329796_: ItemStack?, p_329797_: ClientLevel?, p_329798_: LivingEntity?, p_329799_: Int ->
                val chargedprojectiles = p_329796_!!.get<ChargedProjectiles?>(DataComponents.CHARGED_PROJECTILES)
                if (chargedprojectiles != null && chargedprojectiles.contains(Items.FIREWORK_ROCKET)) 1.0f else 0.0f
            })
    }

    fun makeCustomFishingRods(fishingRod: Item) {
        ItemProperties.register(
            fishingRod,
            ResourceLocation.withDefaultNamespace("cast"),
            { p_174585_: ItemStack?, p_174586_: ClientLevel?, p_174587_: LivingEntity?, p_174588_: Int ->
                if (p_174587_ == null) {
                    return@register 0.0f
                } else {
                    val flag = p_174587_.getMainHandItem() == p_174585_
                    var flag1 = p_174587_.getOffhandItem() == p_174585_
                    if (p_174587_.getMainHandItem().getItem() is FishingRodItem) {
                        flag1 = false
                    }

                    return@register if ((flag || flag1) && p_174587_ is Player && p_174587_.fishing != null) 1.0f else 0.0f
                }
            })
    }
}