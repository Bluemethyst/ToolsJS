package dev.bluemethyst.mods.toolsjs.kubejs.builders

import dev.latvian.mods.kubejs.item.ItemBuilder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BowItem
import net.minecraft.world.item.Item

val BOWS = mutableListOf<BowItem>()

class BowItemBuilder(i: ResourceLocation?) : ItemBuilder(i) {
    override fun createObject(): Item {
        val bow = BowItem(createItemProperties())
        BOWS.add(bow)
        return bow
    }
}