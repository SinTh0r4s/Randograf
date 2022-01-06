package com.sinthoras.randograf.phases.seasons;

import com.sinthoras.randograf.Deck;
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
}
