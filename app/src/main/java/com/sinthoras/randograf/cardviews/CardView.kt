package com.sinthoras.randograf.cardviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sinthoras.randograf.cards.Card

abstract class CardView protected constructor(contentLayerID: Int) : Fragment(contentLayerID) {

    companion object {
        val PARAMETER_CARD_KEY: String = "card"
    }

    private lateinit var card: Card

    protected fun <T: Card> getCard() = card as T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        card = arguments?.getSerializable(PARAMETER_CARD_KEY) as Card
    }
}
