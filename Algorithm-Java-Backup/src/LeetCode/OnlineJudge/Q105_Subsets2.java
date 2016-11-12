/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;

public class Q105_Subsets2 {

    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        ArrayList<ArrayList<Integer>> solution = new Q105_Subsets2().subsetsWithDupMy(num, num.length - 1);
        for (ArrayList<Integer> arrayList : solution) {
            for (Integer integer : arrayList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDupMy(int[] num, int last) {
        if (last < 0) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
            ArrayList<Integer> temp_list = new ArrayList<>();
            temp.add(temp_list);
            return temp;
        }
        ArrayList<ArrayList<Integer>> solution = subsetsWithDupMy(num, last - 1);
        int digit = num[last];
        ArrayList<ArrayList<Integer>> more = new ArrayList<>();
        for (ArrayList<Integer> list : solution) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            temp.add(digit);
            more.add(temp);
        }
        solution.addAll(more);
        return solution;
    }
}
