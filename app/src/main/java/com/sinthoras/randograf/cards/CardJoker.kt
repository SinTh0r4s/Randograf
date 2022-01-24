package com.sinthoras.randograf.cards

import com.sinthoras.randograf.BlockColors
import com.sinthoras.randograf.structure.StructureGenerator
import com.sinthoras.randograf.R

class CardJoker : Card() {
    private val structure = StructureGenerator.generateStructure(1).withColor(BlockColors.ALL)

    fun getStructure() = structure

    override fun getDuration(): Int {
        return 0
    }

    override fun getTitle(): Int {
        return R.string.card_title_joker
    }
}
