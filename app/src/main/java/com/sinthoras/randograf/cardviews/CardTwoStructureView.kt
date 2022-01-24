package com.sinthoras.randograf.cardviews

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sinthoras.randograf.R
import com.sinthoras.randograf.cards.Card
import com.sinthoras.randograf.cards.CardTwoStructures
import com.sinthoras.randograf.structure.StructureView

class CardTwoStructureView : CardView(R.layout.fragment_card_two_structures) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.view?.findViewById<StructureView>(R.id.structureViewA)?.setStructure(getCard<CardTwoStructures>().getStructureA())
        this.view?.findViewById<StructureView>(R.id.structureViewB)?.setStructure(getCard<CardTwoStructures>().getStructureB())
    }

    override fun onResume() {
        super.onResume()
        view?.findViewById<ImageView>(R.id.ruinIcon)?.visibility = if(getCard<CardTwoStructures>().getDrawWithRuin()) View.VISIBLE else View.GONE
    }
}
