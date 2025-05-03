package dev.bluemethyst.mods.toolsjs.kubejs.builders

import dev.latvian.mods.kubejs.item.ItemBuilder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.CrossbowItem
import net.minecraft.world.item.Item

val CROSSBOWS = mutableListOf<CrossbowItem>()

class CrossbowItemBuilder(i: ResourceLocation?) : ItemBuilder(i) {
    override fun createObject(): Item {
        val crossbow = CrossbowItem(createItemProperties())
        CROSSBOWS.add(crossbow)
        return crossbow
    }
}