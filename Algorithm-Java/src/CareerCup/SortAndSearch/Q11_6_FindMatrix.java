/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.SortAndSearch;

public class Q11_6_FindMatrix {

    public void find2(int[][] matrix, int target) {
        int height = matrix.length, width = matrix[0].length;
        int col = 0, row = width - 1;
        while (row >= 0 && col < height) {
            if (matrix[col][row] == target) {
                System.out.println(col + "," + row);
                return;
            } else if (matrix[col][row] < target) {
                ++col;
            } else {
                --row;
            }
        }
        System.out.println("Not Find!!!");
    }

    public void find1(int[][] matrix, int target) {
        int height = matrix.length, width = matrix[0].length;
        Point e = new Point(height - 1, width - 1);
        Point s = new Point(0, 0);
        Point result = find1(matrix, target, s, e);
        if (result == null) {
            System.out.println("Not Find!!!");
        } else {
            System.out.println(result.y + "," + result.x);
        }
    }

    public Point find1(int[][] matrix, int target, Point s, Point e) {
        if (s.x > e.x || s.y > e.y) {
            return null;
        }
        Point pivot = findPivot(matrix, target, s, e);
        if (pivot.inBound(matrix) && matrix[pivot.y][pivot.x] == target) {
            return pivot;
        }
        Point left_top = new Point(pivot.y, s.x);
        Point left_bottom = new Point(e.y, pivot.x - 1);
        Point right_top = new Point(s.y, pivot.x);
        Point right_bottom = new Point(pivot.y - 1, e.x);
        Point p = find1(matrix, target, left_top, left_bottom);
        if (p == null) {
            return find1(matrix, target, right_top, right_bottom);
        } else {
            return p;
        }
    }

    public Point findPivot(int[][] matrix, int target, Point s, Point e) {
        if (s.x > e.x || s.y > e.y || !s.inBound(matrix) || !e.inBound(matrix)) {
            return null;
        }
        Point ss = s.clone();
        int dif = Math.min(e.x - s.x, e.y - s.y);
        Point ee = new Point(ss.y + dif, ss.x + dif);
        Point m = null;
        while (ss.lessThanEqualto(ee)) {
            m = ss.getMedian(ee);
            if (matrix[m.y][m.x] == target) {
                return m;
            } else if (matrix[m.y][m.x] < target) {
                //ss.increment();
                ss.x = m.x + 1;
                ss.y = m.y + 1;
            } else {
                ee.x = m.x - 1;
                ee.y = m.y - 1;
                //ee.decrement();
            }
        }
        return ss;
    }

    class Point {

        public int x;
        public int y;

        public Point() {
        }

        public Point(int _y, int _x) {
            this.x = _x;
            this.y = _y;
        }

        public void increment() {
            ++this.x;
            ++this.y;
        }

        public void decrement() {
            --this.x;
            --this.y;
        }

        public boolean lessThan(Point p) {
            return this.x < p.x && this.y < p.y;
        }

        public boolean moreThan(Point p) {
            return this.x > p.x && this.y > p.y;
        }

        public boolean lessThanEqualto(Point p) {
            return this.x <= p.x && this.y <= p.y;
        }

        public boolean moreThanEqualto(Point p) {
            return this.x >= p.x && this.y >= p.y;
        }

        public Point getMedian(Point p) {
            return new Point((this.y + p.y) / 2, (this.x + p.x) / 2);
        }

        public boolean inBound(int[][] matrix) {
            int height = matrix.length, width = matrix[0].length;
            if (this.x >= 0 && this.x < width && this.y >= 0 && this.y < height) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        protected Point clone() {
            return new Point(y, x);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {15, 20, 70, 85},
            {20, 35, 80, 95},
            {30, 55, 95, 105},
            {40, 80, 120, 120}
        };
        Q11_6_FindMatrix q116 = new Q11_6_FindMatrix();
        q116.find1(matrix, 20);
    }
}
