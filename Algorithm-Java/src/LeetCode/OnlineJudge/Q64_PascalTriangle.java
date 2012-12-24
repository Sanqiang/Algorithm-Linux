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
        ArrayList<ArrayList<Integer>> solution = new Q64_PascalTriangle().generate(9);
        for (ArrayList<Integer> arrayList : solution) {
            for (Integer integer : arrayList) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
