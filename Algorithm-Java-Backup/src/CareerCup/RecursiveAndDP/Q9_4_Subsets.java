/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.RecursiveAndDP;

import java.util.ArrayList;

public class Q9_4_Subsets {

    public ArrayList<ArrayList<Character>> getSubsets2(ArrayList<Character> set) {
        ArrayList<ArrayList<Character>> solution = new ArrayList<>();
        int length = set.size(), subset_size = 1 << length;
        for (int i = 0; i < subset_size; i++) {
            ArrayList<Character> temp = new ArrayList<>();
            for (int pos = 0; pos < length; pos++) {
                if (((1 << pos) & i) > 0) {
                    temp.add(set.get(pos));
                }
            }
            solution.add(temp);
        }
        return solution;
    }

    public ArrayList<ArrayList<Character>> getSubsets(ArrayList<Character> set, int index) {
        if (index == set.size()) {
            ArrayList<ArrayList<Character>> solution = new ArrayList<>();
            ArrayList<Character> empty = new ArrayList<>();
            solution.add(empty);
            return solution;
        }
        ArrayList<ArrayList<Character>> solution = getSubsets(set, index + 1);
        char ch = set.get(index);
        ArrayList<ArrayList<Character>> temp = new ArrayList<>();
        for (ArrayList<Character> arrayList : solution) {
            ArrayList<Character> temp_item = new ArrayList<>();
            temp_item.addAll(arrayList);
            temp_item.add(ch);
            temp.add(temp_item);
        }
        solution.addAll(temp);
        return solution;
    }

    public static void main(String[] args) {
        ArrayList<Character> set = new ArrayList<>();
        String text = Util.TestUtil.generateArrayString(20, 9);
        for (Character ch : text.toCharArray()) {
            set.add(ch);
        }
        Q9_4_Subsets q94 = new Q9_4_Subsets();
        long t1 = System.currentTimeMillis();
        ArrayList<ArrayList<Character>> solution1 = q94.getSubsets(set, 0);
        //print(solution1);
        long t2 = System.currentTimeMillis();
        ArrayList<ArrayList<Character>> solution2 = q94.getSubsets2(set);
        //print(solution2);
        long t3 = System.currentTimeMillis();
        long sp1 = t2 - t1, sp2 = t3 - t2;
        System.out.println(solution1.size() + " Cost " + sp1);
        System.out.println(solution2.size() + " Cost " + sp2);
    }

    static void print(ArrayList<ArrayList<Character>> solution) {
        for (ArrayList<Character> arrayList : solution) {
            for (Character character : arrayList) {
                System.out.print(character);
            }
            System.out.println();
        }

    }
}
