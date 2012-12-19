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

    public ArrayList<ArrayList<Integer>> threeSumEx(int[] num) {
        java.util.Arrays.sort(num);
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        int l = 0, length = num.length, r = length - 1, m = 0;
        while (r - l > 1) {
            int current_sum = num[l] + num[r];
            if (current_sum <= 0) {
                m = r - 1;
            } else if (current_sum > 0) {
                m = l + 1;
            }

            current_sum += num[m];
            if (current_sum > 0) {
                --r;
                /*if (r == m) {
                 --m;
                 }*/
            } else if (current_sum < 0) {
                ++l;
                /*if (l == m) {
                 ++m;
                 }*/
            } else {
                ArrayList<Integer> solution = new ArrayList<>(3);
                solution.add(num[r]);
                solution.add(num[m]);
                solution.add(num[l]);
                solutions.add(solution);
                ++l;
                --r;
                /*if (r == m) {
                 --m;
                 }*/
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
        int[] arr = Util.TestUtil.generateArray(100);
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
