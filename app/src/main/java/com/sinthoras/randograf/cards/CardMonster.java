package com.sinthoras.randograf.cards;

import android.content.res.Resources;

import com.sinthoras.randograf.R;

public class CardMonster extends Card {

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public void paint() {
        // TODO
    }

    @Override
    public String getTitle() {
        return Resources.getSystem().getString(R.string.card_title_monster);
    }
}
