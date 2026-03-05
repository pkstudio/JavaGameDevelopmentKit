package studio.programkode.jgdk.examples;

import studio.programkode.jgdk.API;
import studio.programkode.jgdk.Launcher;
import studio.programkode.jgdk.Plugin;
import studio.programkode.jgdk.library.math.geometry.Point;
import studio.programkode.jgdk.library.resource.Color;


public class MouseCoordinates extends Plugin
{
    static void main() {
        Launcher.createWindow(640, 480, new MouseCoordinates());
    }

    private final Color textColorNormal = new Color(0, 0, 0);
    private final Color textColorPressed = new Color(255, 0, 0);
    private Point position;
    private boolean mousePress = false;

    public void setup(API.Setup window) {
        this.position = window.getCenterPoint();

        window.onMousePress((_) -> this.mousePress = true);
        window.onMouseRelease((_) -> this.mousePress = false);
    }

    public void draw(API window) {
        if (this.mousePress) {
            window.color(this.textColorPressed);
        }
        else {
            window.color(this.textColorNormal);
        }

        window.drawTextCentered(this.position, "Mouse[x%dy%d]".formatted(window.getMouseX(), window.getMouseY()));
    }
}
