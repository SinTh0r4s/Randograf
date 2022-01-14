package com.sinthoras.randograf.structure;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.sinthoras.randograf.BlockColors;

import java.util.List;

public class Structure {

    private final BlockColors color;
    private final List<Block> elements;
    private final Paint paint;

    Structure(List<Block> elements, BlockColors color) {
        this.elements = elements;
        this.color = color;
        paint = new Paint();
        paint.setColor(color.toArgb());
    }

    public Structure copyWithColor(BlockColors color) {
        return new Structure(elements, color);
    }

    public int size() {
        return elements.size();
    }

    public BlockColors getColor() {
        return color;
    }

    public void draw(Canvas canvas) {
        elements.forEach(block -> block.draw(canvas, paint));
    }
}
