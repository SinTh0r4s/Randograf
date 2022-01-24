package com.sinthoras.randograf.cardviews

import android.view.View
import android.widget.ImageView
import com.sinthoras.randograf.R
import com.sinthoras.randograf.cards.covers.CardCover

class CardCoverView : CardView(R.layout.fragment_card_cover) {

    override fun onResume() {
        super.onResume()
        view?.findViewById<ImageView>(R.id.ruinIcon)?.visibility = if(getCard<CardCover>().getDrawWithRuin()) View.VISIBLE else View.GONE
    }
}
