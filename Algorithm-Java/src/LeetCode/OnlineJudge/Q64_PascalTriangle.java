/**
 * Sanqiang Zhao Www.131X.Com Dec 23, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;

public class Q64_PascalTriangle {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            if (i == 0) {
                row.add(1);
            } else {
                ArrayList<Integer> last_row = solution.get(i - 1);
                for (int j = 0; j <= i; j++) {
                    if (j == 0) {
                        row.add(last_row.get(0));
                    } else if (j == i) {
                        row.add(last_row.get(last_row.size() - 1));
                    } else {
                        row.add(last_row.get(j - 1) + last_row.get(j));
                    }
                }
            }
            solution.add(row);
        }
        return solution;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> solution = new Q64_PascalTriangle().generateMy(9);
        for (ArrayList<Integer> arrayList : solution) {
            for (Integer integer : arrayList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> generateMy(int numRows) {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        for (int row = 0; row <= numRows; row++) {
            ArrayList<Integer> level = new ArrayList<>();
            if (row == 0) {
                level.add(1);
            } else {
                ArrayList<Integer> pre_solution = solution.get(row - 1);
                for (int i = 0; i <= pre_solution.size(); i++) {
                    if (i == 0) {
                        level.add(1);
                    } else if (i == pre_solution.size()) {
                        level.add(1);
                    } else {
                        level.add(pre_solution.get(i) + pre_solution.get(i - 1));
                    }
                }
            }
            solution.add(level);
        }
        return solution;
    }
}
