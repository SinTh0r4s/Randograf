package com.sinthoras.randograf.cards;

import com.sinthoras.randograf.Colors;
import com.sinthoras.randograf.structure.Structure;

public class CardVariableColor extends CardTwoStructures {

    private final Colors colorA;
    private final Colors colorB;

    public CardVariableColor(Colors colorA, Colors colorB) {
        super(colorA);
        this.colorA = colorA;
        this.colorB = colorB;
    }

    @Override
    public int getDuration() {
        return 1;
    }

    @Override
    protected Structure generateStructureB(Structure structureA) {
        return structureA.copyWithColor(colorB);
    }
}
