package studio.programkode.jdgk.library.render;

import studio.programkode.jdgk.library.math.geometry.Anchor;
import studio.programkode.jdgk.library.math.geometry.Dimension;
import studio.programkode.jdgk.library.math.geometry.Point;


public interface Squares
{
    //# Outline
    void drawSquare(int x, int y, int size, Anchor anchor);

    default void drawSquare(Point position, int size, Anchor anchor) {
        this.drawSquare(position.x, position.y, size, anchor);
    }

    default void drawSquare(int x, int y, int size) {
        this.drawSquare(x, y, size, Anchor.TOP_LEFT);
    }

    default void drawSquare(Point position, int size) {
        this.drawSquare(position.x, position.y, size, Anchor.TOP_LEFT);
    }
}
