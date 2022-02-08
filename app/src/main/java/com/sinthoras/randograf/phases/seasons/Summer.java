package com.sinthoras.randograf.phases.seasons;

import com.sinthoras.randograf.Deck;
import com.sinthoras.randograf.PhaseColors;
import com.sinthoras.randograf.cards.Card;
import com.sinthoras.randograf.cards.covers.CardSummer;
import com.sinthoras.randograf.phases.ActionButtonStatus;
import com.sinthoras.randograf.phases.Phase;

public class Summer extends Season {

    Summer(Deck deck) {
        super(deck);
    }

    @Override
    public Phase getNextPhase() {
        return new Autumn(deck);
    }

    @Override
    protected int getSeasonDuration() {
        return 8;
    }

    @Override
    public Card getCover() {
        return new CardSummer();
    }

    @Override
    public PhaseColors getPhaseColor() {
        return PhaseColors.SUMMER;
    }

    @Override
    protected ActionButtonStatus getNewSeasonActionButtonStatus() {
        return ActionButtonStatus.NEW_SEASON;
    }
}
