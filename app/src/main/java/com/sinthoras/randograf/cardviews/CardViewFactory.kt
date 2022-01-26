package com.sinthoras.randograf.cardviews

import com.sinthoras.randograf.cards.*
import com.sinthoras.randograf.cards.covers.CardCover
import kotlin.NotImplementedError

object CardViewFactory {
    operator fun get(card: Card): CardView =
        when(card) {
            is CardCover -> CardCoverView()
            is CardJoker -> CardJokerView()
            is CardMonster -> CardMonsterView()
            is CardTwoStructures -> CardTwoStructuresView()
            is CardTwoColors -> CardTwoColorsView()
            else -> throw NotImplementedError()
        }
}