package com.sinthoras.randograf.cardviews

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.sinthoras.randograf.R
import com.sinthoras.randograf.cards.CardTwoColors
import com.sinthoras.randograf.structure.StructureView

class CardTwoColorsView : CardView(R.layout.fragment_card_two_colors) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.view?.findViewById<StructureView>(R.id.structureViewA)?.setStructure(getCard<CardTwoColors>().getStructureA())
        this.view?.findViewById<StructureView>(R.id.structureViewB)?.setStructure(getCard<CardTwoColors>().getStructureB())
    }

    override fun onResume() {
        super.onResume()
        view?.findViewById<ImageView>(R.id.ruinIcon)?.visibility = if(getCard<CardTwoColors>().getDrawWithRuin()) View.VISIBLE else View.GONE
    }
}