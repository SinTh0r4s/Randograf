package com.sinthoras.randograf.structure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.sinthoras.randograf.BlockColors;

import java.io.Serializable;
import java.util.List;

public class Structure implements Serializable {

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

    public BlockColors getColor() {
        return color;
    }

    public void draw(Context context, Canvas canvas, Paint paint) {
        paint.setColor(ContextCompat.getColor(context, color.getColor()));
        elements.forEach(block -> block.draw(canvas, paint));
    }
}
