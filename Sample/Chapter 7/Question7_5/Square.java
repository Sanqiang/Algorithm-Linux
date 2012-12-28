package Question7_5;

public class Square {
	public double left;
	public double top;
	public double bottom;
	public double right;
	public Square(double left, double top, double size) {
		this.left = left;
		this.top = top;
		this.bottom = top + size;
		this.right = left + size;
	}
	
	public Point middle() {
		return new Point((this.left + this.right)/2.0, (this.top + this.bottom)/2.0);
	}
	
	/* Return the point where the line segment connecting mid1 and mid2
	 * intercepts the edge of square 1. That is, draw a line from mid2 to
	 * mid1, and continue it out until the edge of the square.
	 */
	public Point extend(Point mid1, Point mid2, double size) {
		/* The line segment will hit on an edge of the square, 
		 * which is (size / 2) units up, down, left or right of the 
		 * middle. If mid1 is to the left of mid2, then the line 
		 * segment hits on the left of mid1. If mid1 is above mid2,
		 * then the line segment hits above mid1.
		 */
		double xdir = mid1.x < mid2.x ? -1 : 1;
		double ydir = mid1.y < mid2.y ? -1 : 1;
		
		/* If mid1 and mid2 have the same x value, then the slope
		 * calculation will throw a divide by 0 exception. Instead,
		 * we do a special calculation, since we know the line 
		 * segment will hit at the same x coordinate. 
		 */
		if (mid1.x == mid2.x) {
			return new Point(mid1.x, mid1.y + ydir * size / 2.0);
		}
		double slope = (mid1.y - mid2.y) / (mid1.x - mid2.x);
		double x1 = 0;
		double y1 = 0;
		
		/* Calculate x1 and y1 using the equation:
		 * 	slope = (y1 - y2) / (x1 - x2).
		 * Note that if the slope is “steep,” the end of the line 
		 * segment will hit size / 2 units away from the middle on
		 * the y axis. If the slope is “shallow,” the end of the 
		 * line segment will hit size / 2 unit away from the middle
		 * on the x asis.
		 */
		if (Math.abs(slope) == 1) {
			x1 = mid1.x + xdir * size / 2.0;
			y1 = mid1.y + ydir * size / 2.0;
		} else if (Math.abs(slope) < 1) {
			x1 = mid1.x + xdir * size / 2.0;
			y1 = slope * (x1 - mid1.x) + mid1.y; 
		} else {
			y1 = mid1.y + ydir * size / 2.0;
			x1 = (y1 - mid1.y) / slope + mid1.x;
		}
		return new Point(x1, y1);
	}
	
	public Line cut(Square other) {
		Point middle_s = this.middle();
		Point middle_t = other.middle();
		if (middle_s.isEqual(middle_t)) {
			Square bigger = bottom - top > other.bottom - other.top ? this : other;
			return new Line(new Point(bigger.left, bigger.top), new Point(bigger.right, bigger.bottom));
		} else {
			Point point_s = extend(middle_s, middle_t, this.right - this.left);
			Point point_t = extend(middle_t, middle_s, other.right - other.left);
			return new Line(point_s, point_t);
		}
	}
	
	public String toString() {
		return "(" + left + ", " + top + ")|(" + right + "," + bottom + ")";
	}
}
