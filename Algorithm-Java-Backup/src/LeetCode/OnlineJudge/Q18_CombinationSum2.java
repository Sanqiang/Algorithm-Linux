/**
 * Sanqiang Zhao Www.131X.Com Dec 18, 2012
 */
package LeetCode.OnlineJudge;

import Util.TestUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
        ArrayList<ArrayList<Integer>> solutions = new Q18_CombinationSum2().combinationSum(candidates, target);
        for (Iterator<ArrayList<Integer>> it = solutions.iterator(); it.hasNext();) {
            ArrayList<Integer> arrayList = it.next();
            for (Iterator<Integer> it1 = arrayList.iterator(); it1.hasNext();) {
                Integer integer = it1.next();
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        int[] people = TestUtil.generateArray(20, 10, false);
        java.util.Arrays.sort(people);
        long l1 = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> solutions1 = new Q18_CombinationSum2().combinationSumEx(people, 9);
        long l2 = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> solutions2 = new Q18_CombinationSum2().combinationSum(people, 9);
        long l3 = System.currentTimeMillis();
        long span1 = l2 - l1, span2 = l3 - l2;
        System.out.println(solutions1.size() + " Cost " + span1);
        System.out.println(solutions2.size() + " Cost " + span2);
    }

    //my way
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        //RD table
        HashMap<Integer, Integer> candidiate_map = new HashMap<>();
        for (int i = 0; i < candidates.length; i++) {
            if (!candidiate_map.containsKey(candidates[i])) {
                candidiate_map.put(candidates[i], 1);
            } else {
                int val = candidiate_map.get(candidates[i]);
                candidiate_map.put(candidates[i], val + 1);
            }
        }
        ArrayList<ArrayList<Integer>>[] DP = new ArrayList[target + 1];
        for (int cur_target = 1; cur_target <= target; cur_target++) {
            DP[cur_target] = new ArrayList<>();
            Set<Integer> set = candidiate_map.keySet();
            for (Integer i : set) {
                if (i > cur_target) {
                    break;
                } else if (i == cur_target) {
                    ArrayList<Integer> solution = new ArrayList<>();
                    solution.add(cur_target);
                    DP[cur_target].add(solution);
                    break;
                }

                int remaining = cur_target - i;
                if (DP[remaining] != null && DP[remaining].size() > 0) {
                    for (ArrayList<Integer> list : DP[remaining]) {
                        if (list.get(list.size() - 1) > i) {
                            continue;
                        }
                        if (!enoughInMap(candidiate_map, list, i)) {
                            continue;
                        }
                        ArrayList<Integer> solution = new ArrayList<>();
                        solution.addAll(list);
                        solution.add(i);
                        DP[cur_target].add(solution);
                    }
                }
            }
        }
        return DP[target];
    }

    private boolean enoughInMap(HashMap<Integer, Integer> candidiate_map, ArrayList<Integer> list, int key) {
        int count = candidiate_map.get(key);
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == key) {
                --count;
            } else {
                break;
            }
        }
        return count > 0;
    }
}
