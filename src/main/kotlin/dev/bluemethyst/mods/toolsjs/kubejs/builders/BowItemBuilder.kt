package dev.bluemethyst.mods.toolsjs.kubejs.builders

import dev.latvian.mods.kubejs.item.ItemBuilder
import dev.latvian.mods.kubejs.typings.Info
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BowItem
import net.minecraft.world.item.Item

val BOWS = mutableMapOf<BowItem, Boolean>()

class BowItemBuilder(i: ResourceLocation?) : ItemBuilder(i) {

    var changeFovWhileAiming: Boolean = true

    override fun createObject(): Item {
        val bow = BowItem(createItemProperties())
        BOWS.put(bow, changeFovWhileAiming)
        return bow
    }

    @Info( value = "If true, the fov will change while aiming with the bow. Defaults to `true`")
    fun changeFovWhileAiming(change: Boolean): BowItemBuilder {
        changeFovWhileAiming = change
        return this
    }
}