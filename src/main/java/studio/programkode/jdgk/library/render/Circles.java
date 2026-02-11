package studio.programkode.jdgk.library.render;

import studio.programkode.jdgk.library.math.geometry.Anchor;
import studio.programkode.jdgk.library.math.geometry.Point;

public interface Circles
{
    void drawCircle(int x, int y, int radius, Anchor anchor);

    default void drawCircle(Point position, int radius, Anchor anchor) {
        this.drawCircle(position.x, position.y, radius, anchor);
    }

    default void drawCircle(int x, int y, int radius) {
        this.drawCircle(x, y, radius, Anchor.CENTER);
    }

    default void drawCircle(Point position, int radius) {
        this.drawCircle(position.x, position.y, radius, Anchor.CENTER);
    }

}
