package com.sinthoras.randograf.cards

import android.graphics.Canvas
import android.graphics.Paint
import com.sinthoras.randograf.Colors
import com.sinthoras.randograf.MainActivity
import com.sinthoras.randograf.structure.StructureGenerator
import com.sinthoras.randograf.R

class CardJoker : Card() {
    private val structure = StructureGenerator.generateStructure(1).withColor(Colors.ALL)
    override fun getDuration(): Int {
        return 0
    }

    override fun paint(canvas: Canvas, paint: Paint) {
        structure.draw(canvas, paint);
    }

    override fun getTitle(): String {
        return MainActivity.getResourceString(R.string.card_title_joker)
    }
}