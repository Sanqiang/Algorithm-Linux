/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Q1_3Sum {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        java.util.Arrays.sort(num);
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        HashSet<String> cache = new HashSet<>();
        int length = num.length, i = 0;
        for (; i < length - 3; i++) {
            int s = i + 1;
            int e = length - 1;
            while (s < e) {
                int current_sum = num[i] + num[s] + num[e];
                String key = String.valueOf(num[e]) + String.valueOf(num[s]) + String.valueOf(num[i]);
                if (cache.contains(key)) {
                    --e;
                    ++s;
                } else if (current_sum == 0) {
                    ArrayList<Integer> solution = new ArrayList<>(3);
                    solution.add(num[e]);
                    solution.add(num[s]);
                    solution.add(num[i]);
                    solutions.add(solution);
                    cache.add(key);
                    --e;
                    ++s;
                } else if (current_sum > 0) {
                    --e;
                } else {
                    ++s;
                }
            }
        }

        return solutions;
    }

    //My way
    public ArrayList<ArrayList<Integer>> threeSumEx(int[] num) {
        java.util.Arrays.sort(num);
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        HashSet<String> cache = new HashSet<>();
        int length = num.length, i, s, e;
        for (i = 0; i < length - 3; i++) {
            s = i + 1;
            e = length - 1;
            while (s < e) {
                if (num[s] + num[e] + num[i] == 0) {
                    if (cache.contains(String.valueOf(num[i])+String.valueOf(num[s])+String.valueOf(num[e]))) {
                        continue;
                    }
                    cache.add(String.valueOf(num[i])+String.valueOf(num[s])+String.valueOf(num[e]));
                    ArrayList<Integer> solution = new ArrayList<>();
                    solution.add(num[i]);
                    solution.add(num[s]);
                    solution.add(num[e]);
                    solutions.add(solution);
                   ++s;--e;
                } else if (num[s] + num[e] + num[i] < 0) {
                    ++s;
                } else if (num[s] + num[e] + num[i] > 0) {
                    --e;
                }
            }
        }
        return solutions;
    }

    public static void main(String[] args) {
        int[] num = {-1, -1, 0, 1, -4, 2};
        ArrayList<ArrayList<Integer>> solutions = new Q1_3Sum().threeSum(num);
        for (Iterator<ArrayList<Integer>> it = solutions.iterator(); it.hasNext();) {
            ArrayList<Integer> arrayList = it.next();
            for (Iterator<Integer> it1 = arrayList.iterator(); it1.hasNext();) {
                System.out.print(it1.next());
                System.out.print(" ");
            }
            System.out.println();
        }

        //test1
        int[] arr = Util.TestUtil.generateArray(30);
        long t1 = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> solutions1 = new Q1_3Sum().threeSum(arr);
        long t2 = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> solutions2 = new Q1_3Sum().threeSumEx(arr);
        long t3 = System.currentTimeMillis();
        long span1 = t2 - t1;
        long span2 = t3 - t2;
        System.out.println(solutions1.size() + " Cost " + span1);
        System.out.println(solutions2.size() + " Cost " + span2);
    }
}
