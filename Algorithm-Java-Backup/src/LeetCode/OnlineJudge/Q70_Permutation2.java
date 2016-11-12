/**
 * Sanqiang Zhao Www.131X.Com Dec 23, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;

public class Q70_Permutation2 {

    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        ArrayList<ArrayList<Integer>> solution = new Q70_Permutation2().permuteEx(num, 0);
        for (ArrayList<Integer> arrayList : solution) {
            for (Integer integer : arrayList) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> permuteEx(int[] num, int cur_ind) {
        if (cur_ind == num.length - 1) {
            ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(num[cur_ind]);
            solution.add(temp);
            return solution;
        }
        ArrayList<ArrayList<Integer>> solution = permuteEx(num, cur_ind + 1);
        ArrayList<ArrayList<Integer>> next_solution = new ArrayList<>();
        int digit = num[cur_ind];
        for (ArrayList<Integer> arrayList : solution) {
            for (int i = 0; i <= arrayList.size(); i++) {
                ArrayList<Integer> temp = (ArrayList<Integer>) arrayList.clone();
                temp.add(i, digit);
                next_solution.add(temp);
            }
        }
        return next_solution;
    }
}
