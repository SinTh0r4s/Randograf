package com.sinthoras.randograf.cards;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

public abstract class Card extends Fragment {

    protected Card(int contentLayerID) {
        super(contentLayerID);
    }

    protected boolean drawnWithRuin = false;

    public void notifyPriorRuin() {
        drawnWithRuin = true;
    }

    public abstract int getDuration();

    @StringRes
    public abstract int getTitle();
}
