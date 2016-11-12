/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.HashSet;

public class Q3_4Sum {

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        java.util.Arrays.sort(num);
        HashSet<String> cache = new HashSet<>();
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        int i = 0, j = 0, length = num.length;
        for (; i < length - 4; i++) {
            for (j = i + 1; j < length - 3; j++) {
                int s = j + 1;
                int e = length - 1;
                while (s < e) {
                    int curren_sum = num[i] + num[j] + num[s] + num[e];
                    String key = String.valueOf(num[e]) + String.valueOf(num[s]) + String.valueOf(num[j]) + String.valueOf(num[i]);
                    if (cache.contains(key)) {
                        --e;
                        ++s;
                    } else if (curren_sum > target) {
                        --e;
                    } else if (curren_sum < target) {
                        ++s;
                    } else {
                        ArrayList<Integer> solution = new ArrayList<>();
                        solution.add(num[e]);
                        solution.add(num[s]);
                        solution.add(num[j]);
                        solution.add(num[i]);
                        solutions.add(solution);
                        cache.add(key);
                        --e;
                        ++s;
                    }
                }
            }
        }

        return solutions;
    }

    /*
     public ArrayList<ArrayList<Integer>> fourSumEx(int[] num, int target) {
     java.util.Arrays.sort(num);
     ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
     int length = num.length, l = 0, r = length - 1, ml = l + 1, mr = r - 1;
     while (r - l >= 2) {
     int current_sum = num[l] + num[r];
     if (current_sum >= target) {
     ml = l + 1;
     } else if (current_sum < target) {
     ml = r - 1;
     }
     current_sum += num[ml];
     if (current_sum >= target) {
     mr = l + 1;
     if (mr == ml) {
     mr = ml + 1;
     }
     } else if (current_sum < target) {
     mr = r - 1;
     if (mr == ml) {
     mr = ml - 1;
     }
     }
     current_sum += num[mr];
     while (ml < mr) {
     if (current_sum == target) {
     ArrayList<Integer> solution = new ArrayList<>();
     solution.add(num[r]);
     solution.add(num[mr]);
     solution.add(num[ml]);
     solution.add(num[l]);
     solutions.add(solution);
     --mr;
     ++ml;
     } else if (current_sum > target) {
     --mr;
     } else {
     ++ml;
     }
     }
     --r;
     ++l;
     }
     return solutions;

     }
     */
    //my way
    public ArrayList<ArrayList<Integer>> fourSumEx(int[] num, int target) {
        java.util.Arrays.sort(num);
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        HashSet<String> cache = new HashSet<>();
        int length = num.length, i, j, s, e;
        for (i = 0; i < length - 4; i++) {
            for (j = i + 1; j < length - 3; j++) {
                s = j + 1;
                e = length - 1;
                while (s < e) {
                    int sum = num[i] + num[j] + num[s] + num[e];
                    if (sum == target) {
                        String key = String.valueOf(num[i]) + String.valueOf(num[j]) + String.valueOf(num[s]) + String.valueOf(num[e]);
                        if (cache.contains(key)) {
                            continue;
                        }else{
                        cache.add(key);
                        ArrayList<Integer> solution = new ArrayList<>();
                        solution.add(num[i]);
                        solution.add(num[j]);
                        solution.add(num[s]);
                        solution.add(num[e]);
                        solutions.add(solution);}
                        ++s;
                        --e;
                    } else if (sum < target) {
                        ++s;
                    } else if (sum > target) {
                        --e;
                    }
                }
            }
        }
        return solutions;
    }

    public static void main(String[] args) {
        int[] num = {1, 0, -1, 0, -2, 2};
        ArrayList<ArrayList<Integer>> solutions = new Q3_4Sum().fourSum(num, 0);
        for (Iterator<ArrayList<Integer>> it = solutions.iterator(); it.hasNext();) {
            ArrayList<Integer> arrayList = it.next();
            for (Iterator<Integer> it1 = arrayList.iterator(); it1.hasNext();) {
                System.out.print(it1.next());
                System.out.print(" ");
            }
            System.out.println();
        }

        //test
        int[] arr = Util.TestUtil.generateArray(30);
        long t1 = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> solutions1 = new Q3_4Sum().fourSum(arr, 0);
        long t2 = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> solutions2 = new Q3_4Sum().fourSumEx(arr, 0);
        long t3 = System.currentTimeMillis();
        long span1 = t2 - t1;
        long span2 = t3 - t2;
        System.out.println(solutions1.size() + " Cost " + span1);
        System.out.println(solutions2.size() + " Cost " + span2);
    }
}
