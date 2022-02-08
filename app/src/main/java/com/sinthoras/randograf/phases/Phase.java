package com.sinthoras.randograf.phases;

import androidx.annotation.StringRes;

import com.sinthoras.randograf.PhaseColors;
import com.sinthoras.randograf.cards.Card;

public interface Phase {

    Card drawCard();

    Phase getNextPhase();

    boolean isOver();

    Card getCover();

    String getElapsedTime();

    PhaseColors getPhaseColor();

    ActionButtonStatus getActionButtonStatus();
}
