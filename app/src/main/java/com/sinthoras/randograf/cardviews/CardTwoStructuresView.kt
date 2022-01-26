package com.sinthoras.randograf.cardviews

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.sinthoras.randograf.R
import com.sinthoras.randograf.cards.CardTwoStructures
import com.sinthoras.randograf.structure.StructureView

class CardTwoStructuresView : CardView(R.layout.fragment_card_two_structures) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val smallStructure = getCard<CardTwoStructures>().getStructureSmall()
        smallStructure.shiftHorizontal(-1.0)
        this.view?.findViewById<StructureView>(R.id.structureSmallView)?.setStructure(smallStructure)
        this.view?.findViewById<StructureView>(R.id.structureLargeView)?.setStructure(getCard<CardTwoStructures>().getStructureLarge())
    }

    override fun onResume() {
        super.onResume()
        view?.findViewById<ImageView>(R.id.ruinIcon)?.visibility = if(getCard<CardTwoStructures>().getDrawWithRuin()) View.VISIBLE else View.GONE
    }
}
