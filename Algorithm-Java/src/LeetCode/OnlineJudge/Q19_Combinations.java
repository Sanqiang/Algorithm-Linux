/**
 * Sanqiang Zhao Www.131X.Com Dec 18, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;
import java.util.Iterator;

public class Q19_Combinations {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> solutions = new ArrayList<ArrayList<ArrayList<Integer>>>(2);
        solutions.add(new ArrayList<ArrayList<Integer>>());
        solutions.add(new ArrayList<ArrayList<Integer>>());
        int i = 1;
        for (; i <= n; ++i) {
            ArrayList<Integer> temp_list = new ArrayList<>();
            temp_list.add(i);
            solutions.get(0).add(temp_list);
        }
        for (i = 2; i <= k; ++i) {
            ArrayList<ArrayList<Integer>> current_solution = solutions.get((i) % 2);
            ArrayList<ArrayList<Integer>> last_solution = solutions.get((i + 1) % 2);
            ArrayList<ArrayList<Integer>> next_solution = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> list : current_solution) {
                int last_big = list.get(list.size() - 1);
                for (int val = 1; val <= n; ++val) {
                    if (val > last_big) {
                        ArrayList<Integer> temp_list = new ArrayList<>();
                        temp_list.addAll(list);
                        temp_list.add(val);
                        next_solution.add(temp_list);
                    }
                }
            }
            last_solution.clear();
            last_solution.addAll(next_solution);
        }
        return solutions.get(i % 2);
    }

    public ArrayList<ArrayList<Integer>> combineEx(int n, int k) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
        combineHelper(0, 1, k, n, new ArrayList<Integer>(), solutions);
        return solutions;
    }

    private void combineHelper(int last_val, int current_bit, int k, int n, ArrayList<Integer> solution, ArrayList<ArrayList<Integer>> solutions) {
        if (current_bit > k) {
            solutions.add(solution);
            return;
        }
        int val = 1;
        for (; val <= n; ++val) {
            if (val > last_val) {
                ArrayList<Integer> next_solution = (ArrayList<Integer>) solution.clone();
                next_solution.add(val);
                combineHelper(val, current_bit + 1, k, n, next_solution, solutions);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> solutions = new Q19_Combinations().combineMy(4, 2);
        for (Iterator<ArrayList<Integer>> it = solutions.iterator(); it.hasNext();) {
            ArrayList<Integer> arrayList = it.next();
            for (Iterator<Integer> it1 = arrayList.iterator(); it1.hasNext();) {
                Integer integer = it1.next();
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        int k = 15, n = 25;
        long l1 = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> solutions1 = new Q19_Combinations().combine(n, k);
        long l2 = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> solutions2 = new Q19_Combinations().combineEx(n, k);
        long l3 = System.currentTimeMillis();
        long span1 = l2 - l1, span2 = l3 - l2;
        System.out.println(solutions1.size() + " Cost " + span1);
        System.out.println(solutions2.size() + " Cost " + span2);
    }

    //my way
    public ArrayList<ArrayList<Integer>> combineMy(int n, int k) {
        ArrayList<ArrayList<Integer>>[] solutions = new ArrayList[2];
        solutions[0] = new ArrayList<>();
        solutions[1] = new ArrayList<>();
        int i = 0;
        for (int j = 1; j <= n; j++) {
            ArrayList<Integer> solution = new ArrayList<>();
            solution.add(j);
            solutions[0].add(solution);
        }
        while (++i < k) {
            ArrayList<ArrayList<Integer>> pre = solutions[(i + 1) % 2];
            ArrayList<ArrayList<Integer>> cur = solutions[i % 2];
            cur.clear();
            for (ArrayList<Integer> arrayList : pre) {
                for (int j = 1; j <= n; j++) {
                    if (arrayList.get(arrayList.size() - 1) < j) {
                        ArrayList<Integer> solution = new ArrayList<>();
                        solution.addAll(arrayList);
                        solution.add(j);
                        cur.add(solution);
                    }
                }
            }
        }
        return solutions[(i + 1) % 2];
    }
}
