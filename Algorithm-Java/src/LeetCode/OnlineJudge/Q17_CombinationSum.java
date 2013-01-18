/**
 * Sanqiang Zhao Www.131X.Com Dec 18, 2012
 */
package LeetCode.OnlineJudge;

import Util.TestUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Q17_CombinationSum {

    //wrong
    public ArrayList<ArrayList<Integer>> combinationSumDP(int[] candidates, int target) {
        HashMap<Integer, ArrayList<ArrayList<Integer>>> solutions = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        int candidates_index, candidate_length = candidates.length;
        for (int current_sum = 1; current_sum <= target; current_sum++) {
            for (candidates_index = 0; candidates_index < candidate_length; candidates_index++) {
                if (current_sum < candidates[candidates_index]) {
                    continue;
                } else if (current_sum == candidates[candidates_index]) {
                    if (solutions.containsKey(current_sum)) {
                        ArrayList<Integer> temp_list = new ArrayList<Integer>();
                        temp_list.add(candidates[candidates_index]);
                        solutions.get(current_sum).add(temp_list);
                    } else {
                        ArrayList<ArrayList<Integer>> temp_solution = new ArrayList<ArrayList<Integer>>();
                        ArrayList<Integer> temp_list = new ArrayList<Integer>();
                        temp_list.add(candidates[candidates_index]);
                        temp_solution.add(temp_list);
                        solutions.put(current_sum, temp_solution);
                    }
                    continue;
                }
                int remaining_sum = current_sum - candidates[candidates_index];
                if (solutions.containsKey(remaining_sum)) {
                    ArrayList<ArrayList<Integer>> prior_solution = solutions.get(remaining_sum);
                    if (solutions.containsKey(current_sum)) {
                        ArrayList<ArrayList<Integer>> temp_solution = new ArrayList<ArrayList<Integer>>();
                        for (ArrayList<Integer> prior_list : prior_solution) {
                            if (prior_list.get(prior_list.size() - 1) > candidates[candidates_index]) {
                                continue;
                            }
                            ArrayList<Integer> temp_list = new ArrayList<Integer>();
                            temp_list.addAll(prior_list);
                            temp_list.add(candidates[candidates_index]);
                            temp_solution.add(temp_list);
                        }
                        solutions.get(current_sum).addAll(temp_solution);
                    } else {
                        ArrayList<ArrayList<Integer>> temp_solution = new ArrayList<ArrayList<Integer>>();
                        for (ArrayList<Integer> prior_list : prior_solution) {
                            if (prior_list.get(prior_list.size() - 1) >= candidates[candidates_index]) {
                                continue;
                            }
                            ArrayList<Integer> temp_list = new ArrayList<Integer>();
                            temp_list.addAll(prior_list);
                            temp_list.add(candidates[candidates_index]);
                            temp_solution.add(temp_list);
                        }
                        solutions.put(current_sum, temp_solution);
                    }
                } else {
                    continue;
                }
            }
        }

        return solutions.get(target);
    }

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
        for (int i = 0; remaining - i * current_candidate_val >= 0; i++) {
            ArrayList<Integer> next_solution = (ArrayList<Integer>) current_solution.clone();
            for (int n = 0; n < i; n++) {
                next_solution.add(current_candidate_val);
            }
            combinationSumHelper(next_solution, remaining - i * current_candidate_val, candidate_index - 1, candidates, solutions, cache);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {1, 1, 2, 5, 6, 7, 10};
        int target = 8;
        ArrayList<ArrayList<Integer>> solutions = new Q17_CombinationSum().combinationSum(candidates, target);
        for (Iterator<ArrayList<Integer>> it = solutions.iterator(); it.hasNext();) {
            ArrayList<Integer> arrayList = it.next();
            for (Iterator<Integer> it1 = arrayList.iterator(); it1.hasNext();) {
                Integer integer = it1.next();
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        int[] people = TestUtil.generateArray(38, 100, false);
        java.util.Arrays.sort(people);
        long l1 = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> solutions1 = new Q17_CombinationSum().combinationSumDP(people, 50);
        long l2 = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> solutions2 = new Q17_CombinationSum().combinationSumEx(people, 50);
        long l3 = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> solutions3 = new Q17_CombinationSum().combinationSum(people, 50);
        long l4 = System.currentTimeMillis();
        long span1 = l2 - l1, span2 = l3 - l2, span3 = l4 - l3;
        System.out.println(solutions1.size() + " Cost " + span1);
        System.out.println(solutions2.size() + " Cost " + span2);
        System.out.println(solutions3.size() + " Cost " + span3);
    }

    //my way
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        //REMOVE DUPLICATE
        ArrayList<Integer> without_dup = new ArrayList<>();
        for (int i = 1; i < candidates.length; i++) {
            if (candidates[i] != candidates[i - 1]) {
                without_dup.add(candidates[i - 1]);
                if (i == candidates.length - 1) {
                    without_dup.add(candidates[i]);
                }
            }
        }
        ArrayList<ArrayList<Integer>>[] DP = new ArrayList[target + 1];
        for (int cur_target = 1; cur_target <= target; cur_target++) {
            DP[cur_target] = new ArrayList<>();
            /*if (cur_target < candidates[0]) {
             continue;
             }*/
            for (int i = 0; i < without_dup.size(); i++) {
                if (cur_target < without_dup.get(i)) {
                    break;
                } else if (cur_target == without_dup.get(i)) {
                    ArrayList<Integer> solution = new ArrayList<>();
                    solution.add(cur_target);
                    DP[cur_target].add(solution);
                    break;
                }
                int remaining = cur_target - without_dup.get(i);
                if (DP[remaining].size() > 0) {
                    for (ArrayList<Integer> list : DP[remaining]) {
                        if (list.get(list.size() - 1) > without_dup.get(i)) {
                            continue;
                        }
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.addAll(list);
                        temp.add(without_dup.get(i));
                        DP[cur_target].add(temp);
                    }
                }
            }
        }
        return DP[target];
    }
}
