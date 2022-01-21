package com.sinthoras.randograf.cards

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.sinthoras.randograf.BlockColors
import com.sinthoras.randograf.structure.StructureGenerator
import com.sinthoras.randograf.R
import com.sinthoras.randograf.Random
import com.sinthoras.randograf.Random.drawRandomFromCollection
import com.sinthoras.randograf.structure.StructureView

class CardMonster : Card(R.layout.fragment_card_monster) {
    private enum class Direction {
        Clockwise,
        Counterclockwise;

        companion object {
            fun getRandom() = Direction.values()[Random.getRandom(Direction.values().size)]
        }
    }

    private val structure =
        StructureGenerator.generateStructure(Random.getRandomFromTo(3, 5)).withColor(
            BlockColors.MONSTER
        )

    override fun getDuration(): Int {
        return 0
    }

    override fun getTitle(): Int {
        return R.string.card_title_monster
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view?.findViewById<StructureView>(R.id.structureView)?.setStructure(structure)
        val direction = Direction.getRandom()
        view?.findViewById<ImageView>(R.id.rotateCounterClockWise)?.visibility = if(direction == Direction.Counterclockwise) View.VISIBLE else View.GONE
        view?.findViewById<ImageView>(R.id.rotateClockWise)?.visibility = if(direction == Direction.Clockwise) View.VISIBLE else View.GONE
    }
}
