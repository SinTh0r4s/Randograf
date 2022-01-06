package com.sinthoras.randograf.cards;

import android.content.res.Resources;

import com.sinthoras.randograf.Colors;
import com.sinthoras.randograf.R;
import com.sinthoras.randograf.structure.Structure;
import com.sinthoras.randograf.structure.StructureGenerator;

import java.util.Random;

public abstract class CardTwoStructures extends Card {

    private final Structure structureA;
    private final Structure structureB;

    protected final Random random = new Random();

    protected CardTwoStructures(Colors colorA) {
        structureA = StructureGenerator.generateStructure(randomSizeForStrucutreA()).withColor(colorA);
        structureB = generateStructureB(structureA);
    }

    private int randomSizeForStrucutreA() {
        return 4 + random.nextInt() % 2;
    }

    protected abstract Structure generateStructureB(Structure structureA);

    @Override
    public void paint() {
        // TODO
    }

    @Override
    public String getTitle() {
        return Resources.getSystem().getString(R.string.card_title_two_options);
    }
}
