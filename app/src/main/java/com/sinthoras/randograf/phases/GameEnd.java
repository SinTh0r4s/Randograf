package com.sinthoras.randograf.phases;

import androidx.annotation.StringRes;

import com.sinthoras.randograf.PhaseColors;
import com.sinthoras.randograf.R;
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

    @Override
    @StringRes
    public int getActionButtonText() {
        return R.string.label_new_game;
    }
}
