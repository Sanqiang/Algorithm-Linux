/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.RecursiveAndDP;

import java.util.ArrayList;
import java.util.HashMap;

public class Q9_2_GetRobotPath {

    private HashMap<Point, Boolean> cache = new HashMap<>();
    public boolean isConnected(int x, int y, ArrayList<Point> path) {
        boolean result = false;
        Point p = new Point(x, y);
        path.add(p);
        if (cache.containsKey(p)) {
            return cache.get(p);
        }
        if (x == 0 && y == 0) {
            return true;
        }
        if (x > 0 && isfree(x - 1, y)) {
            result = isConnected(x - 1, y, path);
        }
        if (result) {
            return true;
        }
        if (y > 0 && isfree(x, y - 1)) {
            result = isConnected(x, y - 1, path);
        }
        if (!result) {
            path.remove(p);
        }
        cache.put(p, result);
        return result;
    }

    boolean isfree(int x, int y) {
        return true;
    }

    class Point {

        int x;
        int y;

        public Point(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }

    public static void main(String[] args) {
        Q9_2_GetRobotPath q92 = new Q9_2_GetRobotPath();
        ArrayList<Point> path = new ArrayList<>();
        boolean result = q92.isConnected(41, 51, path);
        System.out.println(result);
        for (Point point : path) {
            System.out.println(point.x + "," + point.y);
        }
    }
}
