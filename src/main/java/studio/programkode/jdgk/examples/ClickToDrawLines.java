package studio.programkode.jdgk.examples;

import studio.programkode.jdgk.API;
import studio.programkode.jdgk.Launcher;
import studio.programkode.jdgk.Plugin;
import studio.programkode.jdgk.library.math.geometry.Anchor;
import studio.programkode.jdgk.library.math.geometry.Dimension;
import studio.programkode.jdgk.library.math.geometry.Point;

import java.util.ArrayList;


public class ClickToDrawLines extends Plugin
{
    public static void main(String[] args) {
        Launcher.createWindow(640, 480, new ClickToDrawLines());
    }

    //# Fields
    private final ArrayList<Point> points = new ArrayList<>();
    private boolean mousePress = false;


    public void setup(API.Setup canvas) {
        canvas.onMousePress((_) -> this.mousePress = true);
        canvas.onMouseRelease((point) -> {
            this.mousePress = false;

            this.points.add(point);
        });
    }


    public void draw(API canvas) {
        if (!this.points.isEmpty()) {
            if (this.points.size() > 1) {
                for (int i = 0; i < this.points.size() - 1; i ++) {
                    canvas.drawLine(this.points.get(i), this.points.get(i + 1));
                }
            }

            if (this.mousePress) {
                canvas.drawLine(this.points.getLast(), canvas.getCursor());
            }
        }
    }
}
