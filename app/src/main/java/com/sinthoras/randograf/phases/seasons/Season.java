package com.sinthoras.randograf.phases.seasons;

import com.sinthoras.randograf.Deck;
import com.sinthoras.randograf.cards.Card;
import com.sinthoras.randograf.phases.Phase;

public abstract class Season implements Phase {

    protected final Deck deck;

    protected Season(Deck deck) {
        this.deck = deck;
        this.deck.prepareSeason();
    }

    @Override
    public Card drawCard() {
        return deck.drawCard();
    }

    @Override
    public boolean isSeasonOver() {
        return deck.getElapsedTime() >= getSeasonDuration();
    }

    protected abstract int getSeasonDuration();
}
