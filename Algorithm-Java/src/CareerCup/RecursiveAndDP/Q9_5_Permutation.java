/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.RecursiveAndDP;

import java.util.ArrayList;

public class Q9_5_Permutation {

    public ArrayList<String> getPermuatation(String text) {
        if (text.length() == 1) {
            ArrayList<String> solution = new ArrayList<>();
            solution.add(text);
            return solution;
        }
        String current = text.substring(0, 1);
        String remaining = text.substring(1);
        ArrayList<String> solution = getPermuatation(remaining);
        ArrayList<String> next_solution = new ArrayList<>();
        for (int i = 0; i < solution.size(); i++) {
            ArrayList<String> temp = inject(solution.get(i), current);
            next_solution.addAll(temp);
        }
        return next_solution;
    }

    private ArrayList<String> inject(String text, String ch) {
        ArrayList<String> solution = new ArrayList<>();
        for (int i = 0; i <= text.length(); i++) {
            String left = text.substring(0, i);
            String right = text.substring(i);
            solution.add(left + ch + right);
        }
        return solution;
    }

    public static void main(String[] args) {
        String text = "abc";
        Q9_5_Permutation q95 = new  Q9_5_Permutation();
        ArrayList<String> solution = q95.getPermuatation(text);
        for (String string : solution) {
            System.out.println(string);
        }
    }
}
