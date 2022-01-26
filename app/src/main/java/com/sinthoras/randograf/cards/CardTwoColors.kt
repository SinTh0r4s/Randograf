package com.sinthoras.randograf.cards

import com.sinthoras.randograf.BlockColors
import com.sinthoras.randograf.R
import com.sinthoras.randograf.Random
import com.sinthoras.randograf.structure.StructureGenerator

class CardTwoColors(
    colorA: BlockColors,
    colorB: BlockColors
): Card() {

    private val structureA = StructureGenerator.generateStructure(Random.getRandomFromTo(4, 5)).withColor(colorA)
    private val structureB = structureA.copyWithColor(colorB)

    fun getStructureA() = structureA

    fun getStructureB() = structureB

    override fun getDuration(): Int {
        return 2
    }

    override fun getTitle(): Int {
        return R.string.card_title_two_colors
    }
}