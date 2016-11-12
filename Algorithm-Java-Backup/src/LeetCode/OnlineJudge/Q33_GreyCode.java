/**
 * Sanqiang Zhao Www.131X.Com Dec 20, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;
import java.util.Iterator;

public class Q33_GreyCode {

    public ArrayList<Integer> grayCode(int n) {
        int size = 1 << n, i = 0;
        ArrayList<Integer> solutions = new ArrayList<>();
        for (; i < size; ++i) {
            int num = (i >> 1) ^ i;
            solutions.add(num);
        }
        return solutions;
    }

    //wrong
    public ArrayList<Integer> grayCodeEx(int n) {
        int Biggest = (1 << n) - 1, current = 1;
        ArrayList<Integer> solutions = new ArrayList<>();
        solutions.add(0);
        while (true) {
            solutions.add(current);
            if (current == Biggest) {
                break;
            }
            current <<= 1;
            current += 1;
        }
        current -= 1;
        while (current > 0) {
            solutions.add(current);
            current <<= 1;
            current -= (Biggest + 1);
        }
        return solutions;
    }

    public static void main(String[] args) {
        ArrayList<Integer> solutions = new Q33_GreyCode().grayCode(3);
        for (Iterator<Integer> it = solutions.iterator(); it.hasNext();) {
            Integer integer = it.next();
            System.out.println(integer + " " + Integer.toBinaryString(integer));
        }
        int n = 2;
        long l1 = System.currentTimeMillis();
        ArrayList<Integer> solutions1 = new Q33_GreyCode().grayCode(n);
        long l2 = System.currentTimeMillis();
        ArrayList<Integer> solutions2 = new Q33_GreyCode().grayCodeEx(n);
        long l3 = System.currentTimeMillis();
        long span1 = l2 - l1, span2 = l3 - l2;
        System.out.println(solutions1.size() + " Cost " + span1);
        System.out.println(solutions2.size() + " Cost " + span2);
    }
}
