/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.RecursiveAndDP;

import java.util.ArrayList;
import java.util.HashMap;

public class Q9_10_CreateStackBox {

    class Box {

        public int width;
        public int height;
        public int depth;

        public boolean canBeAbove(Box another) {
            if (another == null) {
                return true;
            } else {
                return this.width < another.width && this.height < another.height && this.depth < another.depth;
            }
        }

        public void print() {
            System.out.append("W:" + width + " H:" + height + " D:" + depth);
        }
    }

    private int getHeight(ArrayList<Box> list) {
        if (list == null) {
            return 0;
        }
        int height = 0;
        for (Box box : list) {
            height += box.height;
        }
        return height;
    }
    HashMap<Box, ArrayList<Box>> cache = new HashMap<>();

    public ArrayList<Box> getLongest(Box[] boxes, Box bottom) {
        if (bottom != null && cache.containsKey(bottom)) {
            return cache.get(bottom);
        }
        ArrayList<Box> solution = null;
        int maxheight = 0;
        for (Box box : boxes) {
            if (box.canBeAbove(bottom)) {
                ArrayList<Box> temp_solution = getLongest(boxes, box);
                int temp_height = getHeight(temp_solution);
                if (temp_height > maxheight) {
                    maxheight = temp_height;
                    solution = temp_solution;
                }
            }
        }
        if (bottom != null) {
            solution.add(0, bottom);
        }
        if (solution == null) {
            solution = new ArrayList<>();
        }
        cache.put(bottom, solution);
        return solution;
    }

    public static void main(String[] args) {
    }
}
