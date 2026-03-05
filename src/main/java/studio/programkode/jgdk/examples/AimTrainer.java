package studio.programkode.jgdk.examples;

import studio.programkode.jgdk.API;
import studio.programkode.jgdk.Launcher;
import studio.programkode.jgdk.Plugin;
import studio.programkode.jgdk.library.math.geometry.Point;

import java.util.ArrayList;

public class AimTrainer extends Plugin
{

    private long timer;
    private int radius = 25;
    private ArrayList<Point> points = new ArrayList<>();

    static void main() {
        Launcher.createWindow(640, 480, new AimTrainer());
    }

    @Override
    public void setup(API.Setup window) {
        this.timer = System.currentTimeMillis();

        window.onMousePress((click) -> {
            int n = 0;
            for (var circle : this.points) {
                if (click.distance(circle) <= this.radius) {
                    this.points.remove(n);
                    break;
                }

                n ++;
            }
        });
    }

    @Override
    public void draw(API window) {
        if (System.currentTimeMillis() - this.timer > 1000) {
            this.points.add(window.getRandomPoint());
            this.timer = System.currentTimeMillis();
        }

        if (!this.points.isEmpty()) {
            for (var circle : this.points) {
                window.drawCircle(circle.x, circle.y, 25);
            }
        }
    }
}
