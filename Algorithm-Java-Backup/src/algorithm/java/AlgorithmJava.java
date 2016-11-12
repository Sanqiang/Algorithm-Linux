package algorithm.java;

import java.util.Stack;

public class AlgorithmJava {

    public static void main(String[] args) {
        char[] plain = "rrwa".toCharArray();
        for (char c : plain) {
            System.out.print(c);
        }
        new AlgorithmJava().encipher(plain, 6);
        for (char c : plain) {
            System.out.print(c);
        }
    }

    void encipher(char[] plain, int x) {
        int len = plain.length;
        exchange(plain, 0, x % len, x, false);
        exchange(plain, x % len + 1, len - 1, x, false);
        exchange(plain, 0, len - 1, x, true);
    }

    void exchange(char[] plain, int lo, int hi, int x, boolean replace) {
        while (lo < hi) {
            //replace
            if (replace) {
                plain[lo] = (char) ((plain[lo] + x) % 26 + 'a');
                plain[hi] = (char) ((plain[hi] + x) % 26 + 'a');
            }
            //move
            char temp = plain[lo];
            plain[lo] = plain[hi];
            plain[hi] = temp;
            lo++;
            hi--;
        }
    }
}
