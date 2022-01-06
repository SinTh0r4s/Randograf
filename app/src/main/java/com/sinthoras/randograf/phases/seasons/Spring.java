package com.sinthoras.randograf.phases.seasons;

import com.sinthoras.randograf.Deck;
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
}
