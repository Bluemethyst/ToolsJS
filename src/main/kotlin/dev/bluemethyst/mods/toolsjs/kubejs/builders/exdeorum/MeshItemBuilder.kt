package dev.bluemethyst.mods.toolsjs.kubejs.builders.exdeorum

import dev.latvian.mods.kubejs.item.ItemBuilder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import thedarkcolour.exdeorum.item.MeshItem

class MeshItemBuilder(i: ResourceLocation?) : ItemBuilder(i) {
    override fun createObject(): Item {
        return MeshItem(createItemProperties())
    }
}