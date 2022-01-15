package com.sinthoras.randograf.phases.seasons;

import androidx.annotation.StringRes;

import com.sinthoras.randograf.Deck;
import com.sinthoras.randograf.R;
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
    public boolean isOver() {
        return deck.getElapsedTime() >= getSeasonDuration();
    }

    protected abstract int getSeasonDuration();

    @Override
    public String getElapsedTime() {
        return "" + deck.getElapsedTime() + " / " + getSeasonDuration();
    }

    @Override
    @StringRes
    public int getActionButtonText() {
        if(isOver()) {
            return R.string.label_next_season;
        }
        return R.string.label_draw_card;
    }
}
