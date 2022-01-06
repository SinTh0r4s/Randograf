package com.sinthoras.randograf.cards;

import com.sinthoras.randograf.Colors;
import com.sinthoras.randograf.structure.Structure;
import com.sinthoras.randograf.structure.StructureGenerator;

public class CardVariableStructure extends CardTwoStructures {

    private final Colors color;

    public CardVariableStructure(Colors color) {
        super(color);
        this.color = color;
    }

    @Override
    public int getDuration() {
        return 2;
    }

    @Override
    protected Structure generateStructureB(Structure structureA) {
        return StructureGenerator.generateStructure(getSizeForStructureB(structureA)).withColor(color);
    }

    private int getSizeForStructureB(Structure structureA) {
        if(structureA.size() <= 4) {
            return 2;
        }
        return 2 + random.nextInt() % 2;
    }
}
