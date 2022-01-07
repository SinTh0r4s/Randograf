package com.sinthoras.randograf.phases;

import com.sinthoras.randograf.cards.Card;
import com.sinthoras.randograf.cards.covers.CardGameStart;
import com.sinthoras.randograf.phases.seasons.Spring;

public class GameStart implements Phase {
    @Override
    public Card drawCard() {
        return getCover();
    }

    @Override
    public Phase getNextPhase() {
        return new Spring();
    }

    @Override
    public boolean isOver() {
        return true;
    }

    @Override
    public Card getCover() {
        return new CardGameStart();
    }
}
