package com.sinthoras.randograf.cards;

import static com.sinthoras.randograf.Random.getRandomFromTo;

import com.sinthoras.randograf.BlockColors;
import com.sinthoras.randograf.structure.Structure;
import com.sinthoras.randograf.structure.StructureGenerator;

public class CardVariableStructure extends CardTwoStructures {

    public CardVariableStructure(BlockColors color) {
        super(color, structureA -> StructureGenerator.generateStructure(getSizeForStructureB(structureA)).withColor(color));
    }

    @Override
    public int getDuration() {
        return 1;
    }

    private static int getSizeForStructureB(Structure structureA) {
        if(structureA.size() <= 4) {
            return 2;
        }
        return getRandomFromTo(2, 3);
    }
}
