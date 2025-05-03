package dev.bluemethyst.mods.toolsjs.kubejs.builders

import dev.latvian.mods.kubejs.item.ItemBuilder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.FishingRodItem
import net.minecraft.world.item.Item

val FISHING_RODS = mutableListOf<FishingRodItem>()

class FishingRodItemBuilder(i: ResourceLocation?) : ItemBuilder(i) {
    override fun createObject(): Item {
        val fishingRod = FishingRodItem(createItemProperties())
        FISHING_RODS.add(fishingRod)
        return fishingRod
    }
}