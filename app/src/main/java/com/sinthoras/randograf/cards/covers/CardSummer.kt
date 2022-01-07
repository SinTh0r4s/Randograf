package com.sinthoras.randograf.cards.covers

import com.sinthoras.randograf.MainActivity
import com.sinthoras.randograf.R

class CardSummer : CardCover() {
    override fun paint() {
        // TODO
    }

    override fun getTitle(): String {
        return MainActivity.getResourceString(R.string.card_title_summer)
    }
}