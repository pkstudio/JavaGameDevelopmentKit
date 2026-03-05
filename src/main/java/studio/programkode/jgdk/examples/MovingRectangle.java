package studio.programkode.jgdk.examples;

import studio.programkode.jgdk.API;
import studio.programkode.jgdk.Launcher;
import studio.programkode.jgdk.Plugin;

import java.awt.event.KeyEvent;


public class MovingRectangle extends Plugin
{
    static void main() {
        Launcher.createWindow(640, 480, new MovingRectangle());
    }

    private boolean moveRight = false;
    private int x = 0;

    public void setup(API.Setup canvas) {
        canvas.onKeyPressed(event -> {
            if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
                this.moveRight = true;
            }
        });

        canvas.onKeyReleased(event -> {
            if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
                this.moveRight = false;
            }
        });
    }

    @Override
    public void update(API.Update canvas) {
        if (this.moveRight) {
            this.x += (int) (100*canvas.getDelta());
        }
    }

    @Override
    public void draw(API canvas) {
        canvas.drawRectangle(this.x, 0, 50, 50);
    }
}
