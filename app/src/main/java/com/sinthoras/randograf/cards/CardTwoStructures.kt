package com.sinthoras.randograf.cards

import com.sinthoras.randograf.BlockColors
import com.sinthoras.randograf.R
import com.sinthoras.randograf.Random.getRandomFromTo
import com.sinthoras.randograf.structure.Structure
import com.sinthoras.randograf.structure.StructureGenerator

class CardTwoStructures(
    color: BlockColors
) : Card() {

    private val structureSmall: Structure
    private val structureLarge: Structure

    fun getStructureSmall() = structureSmall

    fun getStructureLarge() = structureLarge

    override fun getTitle(): Int {
        return R.string.card_title_two_structures
    }

    init {
        structureLarge = StructureGenerator.generateStructure(getRandomFromTo(4, 5)).withColor(color)
        structureSmall = StructureGenerator.generateStructure(getSizeForSmallStructure(structureLarge)).withColor(color)
    }

    override fun getDuration() = 1

    private fun getSizeForSmallStructure(structureLarge: Structure): Int {
        if(structureLarge.size() <= 4) {
            return 2;
        }
        return getRandomFromTo(2, 3);
    }
}
