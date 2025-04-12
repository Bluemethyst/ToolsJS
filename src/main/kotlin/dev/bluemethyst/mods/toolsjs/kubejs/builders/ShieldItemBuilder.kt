package dev.bluemethyst.mods.toolsjs.kubejs.builders

import dev.latvian.mods.kubejs.item.ItemBuilder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.ShieldItem

class ShieldItemBuilder(i: ResourceLocation?) : ItemBuilder(i) {
    override fun createObject(): Item {
        return ShieldItem(createItemProperties())
    }
}