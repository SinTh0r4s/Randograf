package com.sinthoras.randograf.phases;

import com.sinthoras.randograf.PhaseColors;
import com.sinthoras.randograf.cards.Card;
import com.sinthoras.randograf.cards.covers.CardGameEnd;

public class GameEnd implements Phase {

    @Override
    public Card drawCard() {
        return getCover();
    }

    @Override
    public Phase getNextPhase() {
        return new GameStart();
    }

    @Override
    public boolean isOver() {
        return true;
    }

    @Override
    public Card getCover() {
        return new CardGameEnd();
    }

    @Override
    public String getElapsedTime() {
        return "";
    }

    @Override
    public PhaseColors getPhaseColor() {
        return PhaseColors.GAME_END;
    }
}
