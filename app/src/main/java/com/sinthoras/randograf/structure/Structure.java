package com.sinthoras.randograf.structure;

import com.sinthoras.randograf.Colors;

import java.util.List;

public class Structure {

    private final Colors color;
    private final List<Block> elements;

    Structure(List<Block> elements, Colors color) {
        this.elements = elements;
        this.color = color;
    }

    public Structure copyWithColor(Colors color) {
        return new Structure(elements, color);
    }

    public int size() {
        return elements.size();
    }
}
