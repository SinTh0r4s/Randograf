package com.sinthoras.randograf

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sinthoras.randograf.cards.Card
import com.sinthoras.randograf.cards.covers.CardGameStart
import com.sinthoras.randograf.phases.GameStart
import com.sinthoras.randograf.phases.Phase

class Game :  ViewModel() {

    var phase: Phase = GameStart()

    val currentCard: MutableLiveData<Card> = MutableLiveData<Card>()
    val phaseColor: MutableLiveData<PhaseColors> = MutableLiveData<PhaseColors>()
    val actionButtonText: MutableLiveData<Int> = MutableLiveData<Int>()
    val ellapsedTime: MutableLiveData<String> = MutableLiveData<String>()

    init {
        currentCard.value = CardGameStart()
        phaseColor.value = phase.phaseColor
        actionButtonText.value = phase.actionButtonText
        ellapsedTime.value = phase.elapsedTime
    }

    fun drawCard() {
        if(phase.isOver) {
            updatePhase(phase.nextPhase)
        }
        else {
            currentCard.value = phase.drawCard()
        }
        ellapsedTime.value = phase.elapsedTime
        actionButtonText.value = phase.actionButtonText
    }

    private fun updatePhase(phase: Phase) {
        this.phase = phase
        phaseColor.value = phase.phaseColor
        currentCard.value = phase.cover
        actionButtonText.value = phase.actionButtonText
    }

    fun newGame() {
        updatePhase(GameStart())
        ellapsedTime.value = phase.elapsedTime
    }
}
