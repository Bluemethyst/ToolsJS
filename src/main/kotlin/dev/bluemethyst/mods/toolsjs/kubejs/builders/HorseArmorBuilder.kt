package dev.bluemethyst.mods.toolsjs.kubejs.builders

import dev.latvian.mods.kubejs.item.ItemBuilder
import dev.latvian.mods.kubejs.typings.Info
import net.minecraft.core.Holder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.AnimalArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.Item

class HorseArmorBuilder(i: ResourceLocation?) : ItemBuilder(i) {
    private var material: Holder<ArmorMaterial>? = null
    private var texture: ResourceLocation? = null

    @Info(value = "The material you want to use for the horse armor")
    fun material(material: Holder<ArmorMaterial>): HorseArmorBuilder {
        this.material = material
        return this
    }

    @Info(value = "The texture you want to use for the horse armor")
    fun armorTexture(texture: ResourceLocation): HorseArmorBuilder {
        this.texture = texture
        return this
    }

    override fun createObject(): Item {
        val item = object : AnimalArmorItem(material, AnimalArmorItem.BodyType.EQUESTRIAN, false, createItemProperties()) {
            override fun getTexture(): ResourceLocation {

                return this@HorseArmorBuilder.texture ?: super.getTexture()
            }
        }
        return item
    }
}