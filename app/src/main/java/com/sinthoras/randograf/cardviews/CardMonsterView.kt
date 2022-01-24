package com.sinthoras.randograf.cardviews

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sinthoras.randograf.R
import com.sinthoras.randograf.cards.Card
import com.sinthoras.randograf.cards.CardMonster
import com.sinthoras.randograf.structure.StructureView

class CardMonsterView : CardView(R.layout.fragment_card_monster) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.view?.findViewById<StructureView>(R.id.structureView)?.setStructure(getCard<CardMonster>().getStructure())
        val direction = CardMonster.Direction.getRandom()  // TODO
        this.view?.findViewById<ImageView>(R.id.rotateCounterClockWise)?.visibility = if(direction == CardMonster.Direction.Counterclockwise) View.VISIBLE else View.GONE
        this.view?.findViewById<ImageView>(R.id.rotateClockWise)?.visibility = if(direction == CardMonster.Direction.Clockwise) View.VISIBLE else View.GONE
    }

    override fun onResume() {
        super.onResume()
        view?.findViewById<ImageView>(R.id.ruinIcon)?.visibility = if(getCard<CardMonster>().getDrawWithRuin()) View.VISIBLE else View.GONE
    }
}
