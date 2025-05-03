package dev.bluemethyst.mods.toolsjs.event

import dev.bluemethyst.mods.toolsjs.ToolsJS
import dev.bluemethyst.mods.toolsjs.kubejs.builders.BOWS
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent


@EventBusSubscriber(modid = ToolsJS.ID, bus = EventBusSubscriber.Bus.GAME, value = [Dist.CLIENT])
object ModClientEvents {
    @SubscribeEvent
    fun onComputeFovModifierEvent(event: ComputeFovModifierEvent) {
        if (event.getPlayer().isUsingItem() && BOWS.contains(event.getPlayer().getUseItem().getItem())) {
            var fovModifier = 1f
            val ticksUsingItem = event.getPlayer().getTicksUsingItem()
            var deltaTicks = ticksUsingItem.toFloat() / 20f
            if (deltaTicks > 1f) {
                deltaTicks = 1f
            } else {
                deltaTicks *= deltaTicks
            }
            fovModifier *= 1f - deltaTicks * 0.15f
            event.setNewFovModifier(fovModifier)
        }
    }
}