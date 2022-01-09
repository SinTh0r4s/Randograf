package com.sinthoras.randograf.structure;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.ArraySet;

import java.util.Objects;
import java.util.Set;

public class Block {
    private double x;
    private double y;

    public Block(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Set<Block> getNeighbors() {
        final Set<Block> neighbors = new ArraySet<>();
        neighbors.add(new Block(getX() - 1, getY() - 1));
        neighbors.add(new Block(getX() - 1, getY() + 1));
        neighbors.add(new Block(getX() + 1, getY() - 1));
        neighbors.add(new Block(getX() + 1, getY() + 1));
        return neighbors;
    }

    public void subtract(Block other) {
        x -= other.getX();
        y -= other.getY();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        final Block that = (Block) other;
        final double compareMargin = 0.01;
        return floatingPointEqual(x, that.x, compareMargin) && floatingPointEqual(y,that.y, compareMargin);
    }

    private static boolean floatingPointEqual(double a, double b, double margin) {
        return Math.abs(a - b) < margin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void draw(Canvas canvas, Paint paint) {
        float blockSize = canvas.getWidth() /6.0f;
        float centerx = canvas.getWidth() /2.0f;
        float centery = canvas.getHeight() /2.0f;
        float left = (float) (blockSize * x + centerx - blockSize / 2.0f);
        float right = left + blockSize;
        float top = (float) (blockSize * y + centery - blockSize / 2.0f);
        float bottom = top + blockSize;

        RectF rect= new RectF(left,top,right,bottom);
        canvas.drawRect(rect,paint);
    }

}
