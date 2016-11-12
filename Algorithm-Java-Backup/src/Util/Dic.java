/**
 * Sanqiang Zhao Www.131X.Com Jan 11, 2013
 */
package Util;

import java.util.ArrayList;

public class Dic {

    public ArrayList<String> getDic(int num_len, int char_len) {
        ArrayList<String>[] solutions = new ArrayList[2];
        solutions[0] = new ArrayList<>();
        solutions[1] = new ArrayList<>();
        int i = 0;
        for (; i <= 9; i++) {
            solutions[0].add(String.valueOf(i));
        }
        i = 1;
        for (; i < num_len; i++) {
            ArrayList<String> pre = solutions[(i + 1) % 2];
            ArrayList<String> cur = solutions[i % 2];
            cur.clear();
            int len = pre.size();
            for (int j = 0; j < len; j++) {
                String str = pre.get(j);
                for (int num = 1; num <= 9; num++) {
                    cur.add(str + num);
                }
            }
        }
        return solutions[1];
    }

    public static void main(String[] args) {
    }
}
