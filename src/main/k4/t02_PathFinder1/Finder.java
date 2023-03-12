/**
 * https://www.codewars.com/kata/5765870e190b1472ec0022a2
 */

package k4.t02_PathFinder1;

import java.util.ArrayDeque;
import java.util.Arrays;

record Point(int x, int y) {
    static Point of(int x, int y) {
        return new Point(x, y);
    }
}

public class Finder {

    static boolean pathFinder(String mazeStr) {
        final var maze = Arrays.stream(mazeStr.split("\n"))
                .map(String::toCharArray)
                .toArray(char[][]::new);

        final var n = maze.length;
        var queue = new ArrayDeque<Point>() {{
            add(Point.of(0, 0));
        }};

        while (!queue.isEmpty()) {
            var p = queue.pop();

            if (p.x() == n - 1 && p.y() == n - 1) {
                return true;
            }

            if (maze[p.x()][p.y()] != '.') {
                continue;
            }

            maze[p.x()][p.y()] = 'x';
            if (p.x() - 1 >= 0) {
                queue.add(Point.of(p.x() - 1, p.y()));
            }
            if (p.x() + 1 < n) {
                queue.add(Point.of(p.x() + 1, p.y()));
            }
            if (p.y() - 1 >= 0) {
                queue.add(Point.of(p.x(), p.y() - 1));
            }
            if (p.y() + 1 < n) {
                queue.add(Point.of(p.x(), p.y() + 1));
            }
        }

        return false;
    }
}
