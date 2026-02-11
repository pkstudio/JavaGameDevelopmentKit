package studio.programkode.jdgk.library.render;

import studio.programkode.jdgk.library.math.geometry.Anchor;
import studio.programkode.jdgk.library.math.geometry.Dimension;
import studio.programkode.jdgk.library.math.geometry.Point;


public interface Rectangles
{
    //# Outline
    void drawRectangle(int x, int y, int width, int height, Anchor anchor);

    default void drawRectangle(Point position, int width, int height, Anchor anchor) {
        this.drawRectangle(position.x, position.y, width, height, anchor);
    }

    default void drawRectangle(int x, int y, Dimension size, Anchor anchor) {
        this.drawRectangle(x, y, size.width, size.height, anchor);
    }

    default void drawRectangle(Point position, Dimension size, Anchor anchor) {
        this.drawRectangle(position.x, position.y, size.width, size.height, anchor);
    }

    default void drawRectangle(int x, int y, int width, int height) {
        this.drawRectangle(x, y, width, height, Anchor.TOP_LEFT);
    }

    default void drawRectangle(Point position, int width, int height) {
        this.drawRectangle(position.x, position.y, width, height, Anchor.TOP_LEFT);
    }

    default void drawRectangle(int x, int y, Dimension size) {
        this.drawRectangle(x, y, size.width, size.height, Anchor.TOP_LEFT);
    }

    default void drawRectangle(Point position, Dimension size) {
        this.drawRectangle(position.x, position.y, size.width, size.height, Anchor.TOP_LEFT);
    }
}
