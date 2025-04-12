package dev.bluemethyst.mods.toolsjs

import net.minecraft.resources.ResourceLocation
import net.neoforged.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(ToolsJS.ID)
object ToolsJS {
    const val ID = "toolsjs"
    val LOGGER: Logger = LogManager.getLogger()
    fun resource(path: String): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }
}