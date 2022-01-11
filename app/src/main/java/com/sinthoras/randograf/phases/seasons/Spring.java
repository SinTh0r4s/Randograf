package com.sinthoras.randograf.phases.seasons;

import com.sinthoras.randograf.Deck;
import com.sinthoras.randograf.PhaseColors;
import com.sinthoras.randograf.cards.Card;
import com.sinthoras.randograf.cards.covers.CardSpring;
import com.sinthoras.randograf.phases.Phase;

public class Spring extends Season {

    public Spring() {
        super(new Deck());
    }

    @Override
    public Phase getNextPhase() {
        return new Summer(deck);
    }

    @Override
    protected int getSeasonDuration() {
        return 8;
    }

    @Override
    public Card getCover() {
        return new CardSpring();
    }

    @Override
    public PhaseColors getPhaseColor() {
        return PhaseColors.SPRING;
    }
}
