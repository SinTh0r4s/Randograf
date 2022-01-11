package com.sinthoras.randograf.cards

import android.graphics.Canvas
import android.graphics.Paint
import com.sinthoras.randograf.BlockColors
import com.sinthoras.randograf.MainActivity
import com.sinthoras.randograf.structure.StructureGenerator
import com.sinthoras.randograf.R
import com.sinthoras.randograf.Random

class CardMonster : Card() {
    private val structure =
        StructureGenerator.generateStructure(Random.getRandomFromTo(3, 5)).withColor(
            BlockColors.MONSTER
        )

    override fun getDuration(): Int {
        return 0
    }

    override fun paint(canvas: Canvas, paint: Paint) {
        structure.draw(canvas, paint);
    }

    override fun getTitle(): String {
        return MainActivity.getResourceString(R.string.card_title_monster)
    }
}