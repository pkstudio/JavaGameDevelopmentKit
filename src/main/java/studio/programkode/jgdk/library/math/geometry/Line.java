package studio.programkode.jgdk.library.math.geometry;

import java.util.List;
import java.util.Optional;


public class Line
{
    static Optional<Point[]> iterateLine(int resolution, Point... points) {
        return Line.iterateLine(resolution, List.of(points));
    }

    public static Optional<Point[]> iterateLine(int resolution, List<Point> points) {
        if (points.size() < 2) return Optional.empty();

        var size = points.size();
        var n = size - 1;
        var steps = Math.max(2, Math.min(resolution, 64));
        var output = new Point[resolution + 1];

        for (int s = 0; s <= steps; s++) {
            var t = (double) s/steps;

            var work = new Point[size];

            for (int i = 0; i < size; i ++) {
                work[i] = (Point) points.get(i).clone();
            }

            for (int r = 1; r <= n; r ++) {
                for (int j = 0; j <= n - r; j ++) {
                    work[j].setLocation(
                            (1 - t)*work[j].x + t*work[j + 1].x,
                            (1 - t)*work[j].y + t*work[j + 1].y
                    );
                }
            }

            output[s] = new Point(work[0].x, work[0].y);
        }

        return Optional.of(output);
    }
}
