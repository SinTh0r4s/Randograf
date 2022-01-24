package com.sinthoras.randograf.cards

import com.sinthoras.randograf.BlockColors
import com.sinthoras.randograf.R
import com.sinthoras.randograf.Random
import com.sinthoras.randograf.structure.Structure
import com.sinthoras.randograf.structure.StructureGenerator

abstract class CardTwoStructures protected constructor(
    colorA: BlockColors?,
    generator: StructureBGenerator
) : Card() {

    interface StructureBGenerator {
        fun generateStructureB(structureA: Structure?): Structure
    }

    private val structureA: Structure
    private val structureB: Structure

    fun getStructureA() = structureA

    fun getStructureB() = structureB

    override fun getTitle(): Int {
        return R.string.card_title_two_options
    }

    init {
        structureA = StructureGenerator.generateStructure(Random.getRandomFromTo(4, 5)).withColor(colorA)
        structureB = generator.generateStructureB(structureA)
    }
}
