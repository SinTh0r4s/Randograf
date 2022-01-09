package com.sinthoras.randograf.cards.covers

import android.graphics.Canvas
import android.graphics.Paint
import com.sinthoras.randograf.MainActivity
import com.sinthoras.randograf.R

class CardGameEnd : CardCover() {

    override fun paint(canvas: Canvas, paint: Paint) {

    }

    override fun getTitle(): String {
        return MainActivity.getResourceString(R.string.card_title_game_end)
    }
}