package com.sinthoras.randograf.cards.covers;

import com.sinthoras.randograf.R;
import com.sinthoras.randograf.cards.Card;

public abstract class CardCover extends Card {

    protected CardCover() {
        super(R.layout.fragment_card_cover);
    }

    @Override
    public int getDuration() {
        return 0;
    }
}
