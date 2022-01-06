package com.sinthoras.randograf.phases;

import com.sinthoras.randograf.cards.Card;
import com.sinthoras.randograf.cards.CardGameEnd;

public class GameEnd implements Phase {

    @Override
    public Card drawCard() {
        return new CardGameEnd();
    }

    @Override
    public Phase getNextPhase() {
        return this;
    }

    @Override
    public boolean isSeasonOver() {
        return false;
    }
}
