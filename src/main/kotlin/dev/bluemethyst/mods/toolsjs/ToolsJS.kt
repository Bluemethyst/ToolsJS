package dev.bluemethyst.mods.toolsjs

import net.minecraft.resources.ResourceLocation
import net.neoforged.fml.common.Mod
import net.neoforged.bus.api.IEventBus;
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(ToolsJS.ID)
class ToolsJS(modBus: IEventBus) {
    companion object {
        const val ID = "toolsjs"
        val LOGGER: Logger = LogManager.getLogger(ID)
        fun resource(path: String): ResourceLocation {
            return ResourceLocation.fromNamespaceAndPath(ID, path);
        }
    }

    init {
        EventHandler.register(modBus);
    }
}