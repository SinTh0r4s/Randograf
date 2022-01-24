package com.sinthoras.randograf.cardviews

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sinthoras.randograf.R
import com.sinthoras.randograf.cards.Card
import com.sinthoras.randograf.cards.CardJoker
import com.sinthoras.randograf.structure.StructureView

class CardJokerView : CardView(R.layout.fragment_card_joker) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.view?.findViewById<StructureView>(R.id.structureView)?.setStructure(getCard<CardJoker>().getStructure())
    }

    override fun onResume() {
        super.onResume()
        view?.findViewById<ImageView>(R.id.ruinIcon)?.visibility = if(getCard<CardJoker>().getDrawWithRuin()) View.VISIBLE else View.GONE

    }
}
