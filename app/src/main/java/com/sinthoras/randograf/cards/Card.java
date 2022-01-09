package com.sinthoras.randograf.cards;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Card {

    protected boolean drawnWithRuin = false;

    public void notifyPriorRuin() {
        drawnWithRuin = true;
    }

    public abstract int getDuration();

    public abstract void paint(Canvas canvas, Paint paint);

    public abstract String getTitle();
}
