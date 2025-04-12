package dev.bluemethyst.mods.toolsjs.kubejs.builders.exdeorum

import dev.latvian.mods.kubejs.item.ItemBuilder
import dev.latvian.mods.kubejs.typings.Info
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import thedarkcolour.exdeorum.item.WateringCanItem

class WateringcanItemBuilder(i: ResourceLocation?) : ItemBuilder(i) {
    private var capacity = 1000

    @Info(value = "The capacity of the watering can in millibuckets")
    fun capacity(capacity: Int): WateringcanItemBuilder {
        this.capacity = capacity
        return this
    }

    override fun createObject(): Item {
        return WateringCanItem(capacity, createItemProperties())
    }
}