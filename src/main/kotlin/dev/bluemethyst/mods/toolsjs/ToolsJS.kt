package dev.bluemethyst.mods.toolsjs

import dev.bluemethyst.mods.toolsjs.kubejs.builders.BOWS
import dev.bluemethyst.mods.toolsjs.kubejs.builders.CROSSBOWS
import dev.bluemethyst.mods.toolsjs.kubejs.builders.FISHING_RODS
import net.minecraft.resources.ResourceLocation
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.IEventBus
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger


@Mod(ToolsJS.ID)
class ToolsJS(modBus: IEventBus) {
    companion object {
        const val ID = "toolsjs"
        val LOGGER: Logger = LogManager.getLogger(ID)
        fun resource(path: String): ResourceLocation {
            return ResourceLocation.fromNamespaceAndPath(ID, path)
        }
    }

    init {
        EventHandler.register(modBus)
    }

    @EventBusSubscriber(modid = ID, bus = EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
    object ClientModEvents {
        @SubscribeEvent
        fun onClientSetup(event: FMLClientSetupEvent?) {
            for (bow in BOWS) {
                LOGGER.info("Registering bow properties for $bow")
                ModItemProperties.makeCustomBows(bow)
            }
            for (crossbow in CROSSBOWS) {
                LOGGER.info("Registering crossbow properties for $crossbow")
                ModItemProperties.makeCustomCrossbows(crossbow)
            }
            for (fishingRod in FISHING_RODS) {
                LOGGER.info("Registering fishing rod properties for $fishingRod")
                ModItemProperties.makeCustomFishingRods(fishingRod)
            }
        }
    }
}