package dev.bluemethyst.mods.toolsjs

import dev.bluemethyst.mods.toolsjs.kubejs.builders.exdeorum.WATERING_CANS
import net.minecraft.world.item.ItemStack
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.capabilities.Capabilities
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent
import thedarkcolour.exdeorum.item.WateringCanItem

object EventHandler {
    fun register(modBus: IEventBus) {
        modBus.addListener(EventHandler::registerCapabilities)
    }

    private fun registerCapabilities(event: RegisterCapabilitiesEvent) {
        event.registerItem(
            Capabilities.FluidHandler.ITEM,
            { stack: ItemStack?, ctx: Void? -> WateringCanItem.FluidHandler(stack) },
            *WATERING_CANS.toTypedArray()
        )
    }
}