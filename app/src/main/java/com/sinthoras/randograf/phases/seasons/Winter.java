package com.sinthoras.randograf.phases.seasons;

import com.sinthoras.randograf.Deck;
import com.sinthoras.randograf.PhaseColors;
import com.sinthoras.randograf.cards.Card;
import com.sinthoras.randograf.cards.covers.CardWinter;
import com.sinthoras.randograf.phases.ActionButtonStatus;
import com.sinthoras.randograf.phases.GameEnd;
import com.sinthoras.randograf.phases.Phase;

public class Winter extends Season {

    Winter(Deck deck) {
        super(deck);
    }

    @Override
    public Phase getNextPhase() {
        return new GameEnd();
    }

    @Override
    protected int getSeasonDuration() {
        return 6;
    }

    @Override
    public Card getCover() {
        return new CardWinter();
    }

    @Override
    public PhaseColors getPhaseColor() {
        return PhaseColors.WINTER;
    }

    @Override
    protected ActionButtonStatus getNewSeasonActionButtonStatus() {
        return ActionButtonStatus.NEW_SEASON;
    }
}
