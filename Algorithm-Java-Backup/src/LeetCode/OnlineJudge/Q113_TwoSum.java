/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;
import java.util.HashMap;

public class Q113_TwoSum {

    public ArrayList<Integer> twoSum(int[] numbers, int target) {
        ArrayList<Integer> solution = new ArrayList<>();
        int s = 0, length = numbers.length, e = length - 1, i;
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (i = 0; i < length; i++) {
            if (!pos.containsKey(numbers[i])) {
                pos.put(numbers[i], i + 1);
            } else if (numbers[i] * 2 == target) {
                solution.add(pos.get(numbers[i]));
                solution.add(i + 1);
            }
        }
        java.util.Arrays.sort(numbers);
        while (s < e) {
            if (numbers[s] + numbers[e] < target) {
                ++s;
            } else if (numbers[s] + numbers[e] > target) {
                --e;
            } else {
                solution.add(pos.get(numbers[s]));
                solution.add(pos.get(numbers[e]));
                ++s;
                --e;
                /*boolean ss = true, ee = true;
                 while (s + 1 < e && numbers[s] == numbers[s + 1]) {
                 ss = false;
                 ++s;
                 solution.add(pos.get(numbers[s]));
                 solution.add(pos.get(numbers[e]));
                 }
                 while (e - 1 > s && numbers[e] == numbers[e - 1]) {
                 ee = false;
                 --e;
                 solution.add(pos.get(numbers[s]));
                 solution.add(pos.get(numbers[e]));
                 }
                 if (ss) {
                 ++s;
                 }
                 if (ee) {
                 --e;
                 }*/
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 9, 2, 8, 5, 5, 5, 0, 11, 12, 6};
        int target = 10;
        ArrayList<Integer> solution = new Q113_TwoSum().twoSumMy(numbers, target);
        for (int i = 0; i < solution.size() - 1; i += 2) {
            System.out.println(solution.get(i) + "-" + solution.get(1 + i));
        }
    }

    public ArrayList<Integer> twoSumMy(int[] numbers, int target) {
        ArrayList<Integer> solution = new ArrayList<>();
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!pos.containsKey(numbers[i])) {
                pos.put(numbers[i], i + 1);
            } else if (numbers[i] * 2 == target) {
                solution.add(pos.get(numbers[i]));
                solution.add(i + 1);
            }
        }
        java.util.Arrays.sort(numbers);
        int s = 0, e = numbers.length - 1;
        while (s < e) {
            int sum = numbers[s]+numbers[e];
            if (sum == target) {
                solution.add(pos.get(numbers[s]));
                solution.add(pos.get(numbers[e]));
                ++s;
                --e;
            } else if (sum > target) {
                --e;
            } else {
                ++s;
            }
        }
        return solution;
    }
}
