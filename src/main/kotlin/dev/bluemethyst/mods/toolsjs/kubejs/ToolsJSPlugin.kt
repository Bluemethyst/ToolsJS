package dev.bluemethyst.mods.toolsjs.kubejs

import dev.bluemethyst.mods.toolsjs.ToolsJS
import dev.bluemethyst.mods.toolsjs.kubejs.builders.*
import dev.bluemethyst.mods.toolsjs.kubejs.builders.exdeorum.*
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin
import dev.latvian.mods.kubejs.registry.BuilderTypeRegistry
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.neoforged.fml.ModList

@Suppress("SpellCheckingInspection")
class ToolsJSPlugin : KubeJSPlugin {
    override fun init() {
        ToolsJS.LOGGER.info("ToolsJS Loaded Successfully! Happy tooling!")
    }

    override fun registerBuilderTypes(registry: BuilderTypeRegistry?) {
        registry!!.of(Registries.ITEM) { reg ->
            if (ModList.get().isLoaded("exdeorum")) {
                reg.add(ResourceLocation.parse("exdeorum:hammer"), HammerItemBuilder::class.java, ::HammerItemBuilder)
                reg.add(ResourceLocation.parse("exdeorum:crook"), CrookItemBuilder::class.java, ::CrookItemBuilder)
                reg.add(ResourceLocation.parse("exdeorum:watering_can"), WateringCanItemBuilder::class.java, ::WateringCanItemBuilder)
                reg.add(ResourceLocation.parse("exdeorum:mesh"), MeshItemBuilder::class.java, ::MeshItemBuilder)
            }
            reg.add(ResourceLocation.parse("paxel"), PaxelItemBuilder::class.java, ::PaxelItemBuilder)
            reg.add(ResourceLocation.parse("horse_armor"), HorseArmorBuilder::class.java, ::HorseArmorBuilder)
            reg.add(ResourceLocation.parse("shield"), ShieldItemBuilder::class.java, ::ShieldItemBuilder)
            reg.add(ResourceLocation.parse("brush"), BrushItemBuilder::class.java, ::BrushItemBuilder)

            reg.add(ResourceLocation.parse("fishing_rod"), FishingRodItemBuilder::class.java, ::FishingRodItemBuilder)
            reg.add(ResourceLocation.parse("bow"), BowItemBuilder::class.java, ::BowItemBuilder)
            reg.add(ResourceLocation.parse("crossbow"), CrossbowItemBuilder::class.java, ::CrossbowItemBuilder)
        }
    }
}
