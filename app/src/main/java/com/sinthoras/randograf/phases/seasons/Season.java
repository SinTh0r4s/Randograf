package com.sinthoras.randograf.phases.seasons;

import androidx.annotation.StringRes;

import com.sinthoras.randograf.Deck;
import com.sinthoras.randograf.R;
import com.sinthoras.randograf.cards.Card;
import com.sinthoras.randograf.phases.ActionButtonStatus;
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
        if (deck.getElapsedTime() < getSeasonDuration())
            return "Progress: " + deck.getElapsedTime() + " / " + getSeasonDuration();
        else return "Season is over";
    }

    @Override
    public ActionButtonStatus getActionButtonStatus() {
        if(isOver()) {
            return getNewSeasonActionButtonStatus();
        }
        return ActionButtonStatus.DRAW_CARD;
    }

    protected abstract ActionButtonStatus getNewSeasonActionButtonStatus();
}
