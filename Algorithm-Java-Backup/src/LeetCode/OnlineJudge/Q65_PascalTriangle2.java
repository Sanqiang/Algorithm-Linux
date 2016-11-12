/**
 * Sanqiang Zhao Www.131X.Com Dec 23, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;

public class Q65_PascalTriangle2 {

    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> solution = new ArrayList<>(rowIndex);
        solution.add(1);
        int i, j;
        for (i = 1; i < rowIndex; ++i) {
            solution.add(0);
        }
        for (i = 2; i <= rowIndex; ++i) {
            for (j = i - 1; j >= 1; --j) {
                if (j == i) {
                    solution.set(j, solution.get(j - 1));
                } else {
                    solution.set(j, solution.get(j - 1) + solution.get(j));
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        ArrayList<Integer> solution = new Q65_PascalTriangle2().getRowMy(4);
        for (Integer integer : solution) {
            System.out.print(integer + " ");
        }
    }

    public ArrayList<Integer> getRowMy(int rowIndex) {
        ArrayList<Integer> solution = new ArrayList<>(rowIndex);
        for (int row = 0; row <= rowIndex; row++) {
            if (row == 0) {
                solution.add(1);
            } else {
                for (int i = row; i >= 1; i--) {
                    if (i == row) {
                        solution.add(1);
                    } else {
                        solution.set(i, solution.get(i) + solution.get(i - 1));
                    }
                }
            }
        }
        return solution;
    }
}
