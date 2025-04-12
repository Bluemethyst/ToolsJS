package dev.bluemethyst.mods.toolsjs

// CREDIT TO https://github.com/BlakeBr0/Cucumber/blob/1.2!/src/main/java/com/blakebr0/cucumber/lib/ModTags.java

import net.minecraft.tags.BlockTags
import net.minecraft.tags.TagKey
import net.minecraft.world.level.block.Block

object ModTags {
    val MINEABLE_WITH_PAXEL: TagKey<Block> = BlockTags.create(ToolsJS.resource("mineable/paxel"))
    val MINEABLE_WITH_SICKLE: TagKey<Block> = BlockTags.create(ToolsJS.resource("mineable/sickle"))
}