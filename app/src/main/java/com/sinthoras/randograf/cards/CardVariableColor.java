package com.sinthoras.randograf.cards;

import com.sinthoras.randograf.Colors;
import com.sinthoras.randograf.structure.Structure;

public class CardVariableColor extends CardTwoStructures {

    public CardVariableColor(Colors colorA, Colors colorB) {
        super(colorA, structureA -> structureA.copyWithColor(colorB));
    }

    @Override
    public int getDuration() {
        return 2;
    }
}
