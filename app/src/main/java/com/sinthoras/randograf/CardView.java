package com.sinthoras.randograf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.sinthoras.randograf.cards.Card;
import com.sinthoras.randograf.cards.covers.CardGameStart;

public class CardView extends View {

    private final Paint paint = new Paint();
    private Card card = new CardGameStart();

    public CardView(Context context) {
        super(context);
        init();
    }

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint.setAntiAlias(true);
    }

    public void setCard(Card card) {
        this.card = card;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        card.paint(canvas, paint);
    }
}
