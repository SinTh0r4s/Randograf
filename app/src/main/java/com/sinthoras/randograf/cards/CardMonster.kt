package com.sinthoras.randograf.cards

import com.sinthoras.randograf.BlockColors
import com.sinthoras.randograf.structure.StructureGenerator
import com.sinthoras.randograf.R
import com.sinthoras.randograf.Random

class CardMonster : Card() {
    enum class Direction {
        Clockwise,
        Counterclockwise;

        companion object {
            fun getRandom() = values()[Random.getRandom(values().size)]
        }
    }

    private val structure =
        StructureGenerator.generateStructure(Random.getRandomFromTo(3, 5)).withColor(
            BlockColors.MONSTER
        )

    fun getStructure() = structure

    override fun getDuration(): Int {
        return 0
    }

    override fun getTitle(): Int {
        return R.string.card_title_monster
    }
}
