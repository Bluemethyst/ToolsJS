package dev.bluemethyst.mods.toolsjs.kubejs.builders

import dev.latvian.mods.kubejs.item.ItemBuilder
import dev.latvian.mods.kubejs.typings.Info
import net.minecraft.core.Holder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.AnimalArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.Item

class WolfArmorBuilder(i: ResourceLocation?) : ItemBuilder(i) {
    private var texture: ResourceLocation? = null
    private var material: Holder<ArmorMaterial>? = null

    @Info(value = "The material you want to use for the wolf armor")
    fun material(material: Holder<ArmorMaterial>): WolfArmorBuilder {
        this.material = material
        return this
    }

    @Info(value = "The texture you want to use for the wolf armor")
    fun armorTexture(texture: ResourceLocation): WolfArmorBuilder {
        this.texture = texture
        return this
    }

    override fun createObject(): Item {
        val item = object : AnimalArmorItem(material, AnimalArmorItem.BodyType.CANINE, false, createItemProperties()) {
            override fun getTexture(): ResourceLocation {
                return this@WolfArmorBuilder.texture ?: super.getTexture()
            }
        }
        return item
    }
}