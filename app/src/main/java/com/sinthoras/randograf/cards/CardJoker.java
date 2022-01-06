package com.sinthoras.randograf.cards;

import android.content.res.Resources;

import com.sinthoras.randograf.Colors;
import com.sinthoras.randograf.R;
import com.sinthoras.randograf.structure.Structure;
import com.sinthoras.randograf.structure.StructureGenerator;

public class CardJoker extends Card {

    private final Structure structure = StructureGenerator.generateStructure(1).withColor(Colors.JOKER);

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public void paint() {
        // TODO
    }

    @Override
    public String getTitle() {
        return Resources.getSystem().getString(R.string.card_title_joker);
    }
}
