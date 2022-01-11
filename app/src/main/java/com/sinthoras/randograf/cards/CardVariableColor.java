package com.sinthoras.randograf.cards;

import com.sinthoras.randograf.BlockColors;

public class CardVariableColor extends CardTwoStructures {

    public CardVariableColor(BlockColors colorA, BlockColors colorB) {
        super(colorA, structureA -> structureA.copyWithColor(colorB));
    }

    @Override
    public int getDuration() {
        return 2;
    }
}
