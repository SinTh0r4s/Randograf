package com.sinthoras.randograf.cardviews

import com.sinthoras.randograf.cards.Card
import com.sinthoras.randograf.cards.covers.CardCover
import com.sinthoras.randograf.cardviews.CardCoverView
import com.sinthoras.randograf.cards.CardJoker
import com.sinthoras.randograf.cardviews.CardJokerView
import com.sinthoras.randograf.cards.CardMonster
import com.sinthoras.randograf.cardviews.CardMonsterView
import com.sinthoras.randograf.cards.CardTwoStructures
import com.sinthoras.randograf.cardviews.CardTwoStructureView
import kotlin.NotImplementedError

object CardViewFactory {
    operator fun get(card: Card?): CardView =
        when(card) {
            is CardCover -> CardCoverView()
            is CardJoker -> CardJokerView()
            is CardMonster -> CardMonsterView()
            is CardTwoStructures -> CardTwoStructureView()
            else -> throw NotImplementedError()
        }
}