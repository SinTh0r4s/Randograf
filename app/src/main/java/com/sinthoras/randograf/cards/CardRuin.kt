package com.sinthoras.randograf.cards

import com.sinthoras.randograf.MainActivity
import com.sinthoras.randograf.R

class CardRuin : Card() {
    override fun getDuration(): Int {
        return 0
    }

    override fun paint() {
        // TODO
    }

    override fun getTitle(): String {
        return MainActivity.getResourceString(R.string.card_title_ruin);
    }
}