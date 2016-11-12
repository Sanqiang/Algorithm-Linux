/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;

public class Q106_SubstringWithConcatenation {

    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> solution = new ArrayList<>();
        int i, j, l_size = L.length, step = L[0].length(), s_length = S.length();
        //filter duplicate
        java.util.Arrays.sort(L);
        ArrayList<Integer> counts = new ArrayList<>();
        ArrayList<String> entity = new ArrayList<>();
        for (i = 0; i < l_size; i++) {
            entity.add(L[i]);
            int count = 1;
            while (i + 1 < l_size && L[i].equals(L[i + 1])) {
                ++count;
            }
            counts.add(count);
        }
        //
        int entity_size = entity.size();
        int starts[] = new int[s_length];
        for (i = 0; i < s_length; i++) {
            String str = S.substring(i);
            starts[i] = -1;
            for (j = 0; j < entity_size; j++) {
                if (str.startsWith(entity.get(j))) {
                    starts[i] = j;
                }
            }
        }
        //
        for (i = 0; i <= s_length - step * l_size; i++) {
            int perm[] = new int[l_size];
            boolean need_test = true;
            for (j = 0; j < l_size; j++) {
                perm[j] = starts[i + step * j];
                if (perm[j] == -1) {
                    need_test = false;
                    break;
                }
            }
            if (need_test && testPerm(perm, counts)) {
                solution.add(i);
            }
        }
        return solution;
    }

    private boolean testPerm(int perm[], ArrayList<Integer> counts) {
        int length = counts.size(), i;
        int tab[] = new int[length];
        for (i = 0; i < perm.length; i++) {
            ++tab[perm[i]];
        }
        for (i = 0; i < length; i++) {
            if (counts.get(i) != tab[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String L[] = {"bar", "foo"};
        String S = "barbarxxxfoobar";
        ArrayList<Integer> solution = new Q106_SubstringWithConcatenation().findSubstringMy(S, L);
        for (Integer integer : solution) {
            System.out.println(integer);
        }
    }

    public ArrayList<Integer> findSubstringMy(String S, String[] L) {
        ArrayList<Integer> solution = new ArrayList<>();
        int s_len = S.length(), l_len = L.length;
        int[] pos = new int[s_len];
        for (int i = 0; i < s_len; i++) {
            pos[i] = -1;
        }
        for (int i = 0; i < s_len; i++) {
            for (int g = 0; g < l_len; g++) {
                if (S.startsWith(L[g], i)) {
                    pos[i] = g;
                    break;
                }
            }
        }
        for (int i = 0; i < s_len; i++) {
            if (pos[i] != -1) {
                boolean[] find = new boolean[l_len];
                if (match(pos, find, i, L[0].length())) {
                    solution.add(i);
                }
            }
        }
        return solution;
    }

    boolean match(int[] pos, boolean[] find, int i, int len) {
        int match = 0;
        for (int j = i; j < pos.length; j += len) {
            int p = pos[j];
            if (p != - 1) {
                if (find[p]) {
                    return false;
                } else {
                    ++match;
                    find[p] = true;
                }
            }
        }
        if (match == find.length) {
            return true;
        } else {
            return false;
        }
    }
}
