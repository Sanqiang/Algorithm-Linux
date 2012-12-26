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
        int length = counts.size(),i;
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
        ArrayList<Integer> solution = new Q106_SubstringWithConcatenation().findSubstring(S, L);
        for (Integer integer : solution) {
            System.out.println(integer);
        }
    }
}
