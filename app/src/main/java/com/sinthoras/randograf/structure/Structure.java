package com.sinthoras.randograf.structure;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.sinthoras.randograf.BlockColors;

import java.util.List;

public class Structure {

    private final BlockColors color;
    private final List<Block> elements;

    Structure(List<Block> elements, BlockColors color) {
        this.elements = elements;
        this.color = color;
    }

    public Structure copyWithColor(BlockColors color) {
        return new Structure(elements, color);
    }

    public int size() {
        return elements.size();
    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color.toArgb());
        elements.forEach(block -> block.draw(canvas, paint));
    }
}
