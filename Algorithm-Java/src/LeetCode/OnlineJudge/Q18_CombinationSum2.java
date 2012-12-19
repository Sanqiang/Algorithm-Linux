/**
 * Sanqiang Zhao Www.131X.Com Dec 18, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Q18_CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSumEx(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
        HashSet<String> cache = new HashSet<String>();
        combinationSumHelper(new ArrayList<Integer>(), target, candidates.length - 1, candidates, solutions, cache);
        return solutions;
    }

    private void combinationSumHelper(ArrayList<Integer> current_solution, int remaining, int candidate_index, int[] candidates, ArrayList<ArrayList<Integer>> solutions, HashSet<String> cache) {
        if (remaining == 0) {
            StringBuilder sb = new StringBuilder();
            for (int num : current_solution) {
                sb.append(num);
            }
            if (!cache.contains(sb.toString())) {
                solutions.add(current_solution);
            }
            cache.add(sb.toString());
        }
        if (candidate_index < 0) {
            return;
        }
        int current_candidate_val = candidates[candidate_index];
        for (int i = 0; i <= 1; i++) {
            ArrayList<Integer> next_solution = (ArrayList<Integer>) current_solution.clone();
            if (i == 1) {
                next_solution.add(current_candidate_val);
            }
            combinationSumHelper(next_solution, remaining - i * current_candidate_val, candidate_index - 1, candidates, solutions, cache);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {1, 1, 2, 5, 6, 7, 10};
        int target = 8;
        ArrayList<ArrayList<Integer>> solutions = new Q18_CombinationSum2().combinationSumEx(candidates, target);
        for (Iterator<ArrayList<Integer>> it = solutions.iterator(); it.hasNext();) {
            ArrayList<Integer> arrayList = it.next();
            for (Iterator<Integer> it1 = arrayList.iterator(); it1.hasNext();) {
                Integer integer = it1.next();
                System.out.print(integer + " ");
            }
            System.out.println();

        }
    }
}
