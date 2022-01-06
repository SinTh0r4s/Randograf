package com.sinthoras.randograf.phases.seasons;

import com.sinthoras.randograf.Deck;
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
}
