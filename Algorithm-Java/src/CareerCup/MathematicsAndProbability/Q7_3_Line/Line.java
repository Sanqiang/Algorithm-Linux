/**
 * Sanqiang Zhao Www.131X.Com Dec 28, 2012
 */
package CareerCup.MathematicsAndProbability.Q7_3_Line;

import java.util.HashMap;
import sun.net.www.content.audio.x_aiff;

public class Line {

    final static double epsilon = 0.00001;
    public double slope;
    public double yintercept;
    public boolean infinite_slope;

    public Line(double _slope, double _yintercept) {
        this.yintercept = _yintercept;
        this.slope = _slope;
        //y = slope * x + yintercept
    }

    public Line(Point p1, Point p2) {
        if (Math.abs(p2.x - p1.x) > epsilon) {
            this.slope = (p2.y - p1.y) / (p2.x - p1.x);
            this.infinite_slope = false;
        } else {
            this.infinite_slope = true;
        }
        if (infinite_slope) {
            this.yintercept = p1.x;
        } else {
            this.yintercept = p1.y - slope * p1.x;
        }

    }

    @Override
    public int hashCode() {
        //return super.hashCode();
        return (int) (100 * slope) * (int) (yintercept * 100) * (infinite_slope ? 1 : -1);
    }

    public boolean isIntersect(Line another) {
        return Math.abs(this.slope - another.slope) > epsilon
                || Math.abs(this.yintercept - another.yintercept) < epsilon;
    }

    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj);
        Line another = (Line) obj;
        return Math.abs(this.slope - another.slope) < epsilon
                && Math.abs(this.yintercept - another.yintercept) < epsilon
                && this.infinite_slope == another.infinite_slope;
    }

    public static void main(String[] args) {
        Line l1 = new Line(new Point(0, 0), new Point(1, 1));
        Line l2 = new Line(new Point(0, 0), new Point(-1, -1));
        Line l3 = new Line(new Point(0, 0), new Point(2, 2));
        Line l4 = new Line(new Point(2, 2), new Point(1, 1));
        HashMap<Line,Integer> count  = new HashMap<>();
        count.put(l1, 4);
        count.put(l1, 3);
        count.put(l1, 2);
        count.put(l1, 1);
    }
}
