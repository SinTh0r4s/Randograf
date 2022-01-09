package com.sinthoras.randograf.structure;

import android.graphics.Canvas;
import android.graphics.Paint;

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

    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color.getColor().toArgb();
        elements.forEach(block -> block.draw(canvas, paint));
    }
}
