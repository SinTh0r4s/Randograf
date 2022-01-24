package com.sinthoras.randograf.cards

import com.sinthoras.randograf.R

class CardRuin : Card() {

    override fun getDuration(): Int {
        return 0
    }

    override fun getTitle(): Int {
        return R.string.card_title_ruin
    }
}
