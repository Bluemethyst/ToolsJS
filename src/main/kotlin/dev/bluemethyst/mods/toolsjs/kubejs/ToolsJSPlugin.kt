package dev.bluemethyst.mods.toolsjs.kubejs

import dev.bluemethyst.mods.toolsjs.ToolsJS
import dev.bluemethyst.mods.toolsjs.kubejs.builders.*
import dev.bluemethyst.mods.toolsjs.kubejs.builders.exdeorum.*
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin
import dev.latvian.mods.kubejs.registry.BuilderTypeRegistry
import net.minecraft.core.registries.Registries
import net.neoforged.fml.ModList

@Suppress("SpellCheckingInspection")
class ToolsJSPlugin : KubeJSPlugin {
    override fun init() {
        ToolsJS.LOGGER.info("ToolsJS Loaded Successfully! Happy tooling!")
    }

    override fun registerBuilderTypes(registry: BuilderTypeRegistry?) {
        registry!!.of(Registries.ITEM) { reg ->
            if (ModList.get().isLoaded("exdeorum")) {
                reg.add("exdeorum:hammer", HammerItemBuilder::class.java, ::HammerItemBuilder)
                reg.add("exdeorum:crook", CrookItemBuilder::class.java, ::CrookItemBuilder)
                reg.add("exdeorum:watering_can", WateringCanItemBuilder::class.java, ::WateringCanItemBuilder)
                reg.add("exdeorum:mesh", MeshItemBuilder::class.java, ::MeshItemBuilder)
            }
            reg.add("paxel", PaxelItemBuilder::class.java, ::PaxelItemBuilder)
            reg.add("horse_armor", HorseArmorBuilder::class.java, ::HorseArmorBuilder)
            reg.add("shield", ShieldItemBuilder::class.java, ::ShieldItemBuilder)
            reg.add("brush", BrushItemBuilder::class.java, ::BrushItemBuilder)
            reg.add("fishing_rod", FishingRodItemBuilder::class.java, ::FishingRodItemBuilder)

            reg.add("bow", BowItemBuilder::class.java, ::BowItemBuilder)
            reg.add("crossbow", CrossbowItemBuilder::class.java, ::CrossbowItemBuilder)
        }
    }
}
