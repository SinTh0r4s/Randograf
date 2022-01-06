package com.sinthoras.randograf.cards;

public abstract class Card {

    protected boolean drawnWithRuin = false;

    public void notifyPriorRuin() {
        drawnWithRuin = true;
    }

    public abstract int getDuration();

    public abstract void paint();

    public abstract String getTitle();
}
