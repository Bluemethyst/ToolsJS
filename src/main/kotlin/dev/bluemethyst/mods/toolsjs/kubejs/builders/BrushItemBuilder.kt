package dev.bluemethyst.mods.toolsjs.kubejs.builders

import dev.latvian.mods.kubejs.item.ItemBuilder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BrushItem
import net.minecraft.world.item.Item

class BrushItemBuilder(i: ResourceLocation?) : ItemBuilder(i) {
    override fun createObject(): Item {
        return BrushItem(createItemProperties())
    }
}