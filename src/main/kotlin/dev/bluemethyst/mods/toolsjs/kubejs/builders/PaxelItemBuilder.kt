package dev.bluemethyst.mods.toolsjs.kubejs.builders

import dev.bluemethyst.mods.toolsjs.items.BasePaxelItem
import dev.latvian.mods.kubejs.item.custom.DiggerItemBuilder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.Tier
import java.util.function.Function

class PaxelItemBuilder(i: ResourceLocation) : DiggerItemBuilder(
    i,
    0.5f,
    -2f,
    { tier: Tier, properties ->
        BasePaxelItem(tier, Function { properties })
    }
) {
    override fun createObject(): Item {
        return BasePaxelItem(
            toolTier,
            Function { createItemProperties() }
        )
    }
}
