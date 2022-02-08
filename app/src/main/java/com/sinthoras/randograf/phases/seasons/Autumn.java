package com.sinthoras.randograf.phases.seasons;

import com.sinthoras.randograf.Deck;
import com.sinthoras.randograf.PhaseColors;
import com.sinthoras.randograf.cards.Card;
import com.sinthoras.randograf.cards.covers.CardAutumn;
import com.sinthoras.randograf.phases.ActionButtonStatus;
import com.sinthoras.randograf.phases.Phase;

public class Autumn extends Season {

    Autumn(Deck deck) {
        super(deck);
    }

    @Override
    public Phase getNextPhase() {
        return new Winter(deck);
    }

    @Override
    protected int getSeasonDuration() {
        return 7;
    }

    @Override
    public Card getCover() {
        return new CardAutumn();
    }

    @Override
    public PhaseColors getPhaseColor() {
        return PhaseColors.AUTUMN;
    }

    @Override
    protected ActionButtonStatus getNewSeasonActionButtonStatus() {
        return ActionButtonStatus.NEW_SEASON;
    }
}
