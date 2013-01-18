/**
 * Sanqiang Zhao Www.131X.Com Dec 21, 2012
 */
package LeetCode.OnlineJudge;

import Util.TestUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Q42_LetterCombinationPhoneNum {

    public ArrayList<String> letterCombinationsEx(String digits) {
        HashMap<Integer, Character[]> mapper = new HashMap<>();
        mapper.put(0, new Character[]{'@'});
        mapper.put(1, new Character[]{'$'});
        mapper.put(2, new Character[]{'a', 'b', 'c'});
        mapper.put(3, new Character[]{'d', 'e', 'f'});
        mapper.put(4, new Character[]{'g', 'h', 'i'});
        mapper.put(5, new Character[]{'j', 'k', 'l'});
        mapper.put(6, new Character[]{'m', 'n', 'o'});
        mapper.put(7, new Character[]{'p', 'q', 'r', 's'});
        mapper.put(8, new Character[]{'t', 'u', 'v'});
        mapper.put(9, new Character[]{'w', 'x', 'y', 'z'});
        int length = digits.length();
        ArrayList<String> solution = new ArrayList<>();
        letterCombinationsHelper(digits, 0, length, "", mapper, solution);
        return solution;
    }

    public ArrayList<String> letterCombinations(String digits) {
        HashMap<Integer, char[]> mapper = new HashMap<>();
        mapper.put(0, new char[]{'@'});
        mapper.put(1, new char[]{'$'});
        mapper.put(2, new char[]{'a', 'b', 'c'});
        mapper.put(3, new char[]{'d', 'e', 'f'});
        mapper.put(4, new char[]{'g', 'h', 'i'});
        mapper.put(5, new char[]{'j', 'k', 'l'});
        mapper.put(6, new char[]{'m', 'n', 'o'});
        mapper.put(7, new char[]{'p', 'q', 'r', 's'});
        mapper.put(8, new char[]{'t', 'u', 'v'});
        mapper.put(9, new char[]{'w', 'x', 'y', 'z'});
        ArrayList<String>[] solutions = new ArrayList[2];
        solutions[0] = new ArrayList<>();
        solutions[1] = new ArrayList<>();
        for (char ch : mapper.get(digits.charAt(0) - '0')) {
            solutions[0].add(String.valueOf(ch));
        }
        int i = 1, length = digits.length();
        for (; i < length; ++i) {
            for (String pre_text : solutions[(i - 1) % 2]) {
                for (char ch : mapper.get(digits.charAt(i) - '0')) {
                    solutions[i % 2].add(pre_text + String.valueOf(ch));
                }
            }
            solutions[(i - 1) % 2].clear();
        }
        return solutions[(i - 1) % 2];
    }

    private void letterCombinationsHelper(String digit, int i, int length, String cur,
            HashMap<Integer, Character[]> mapper, ArrayList<String> solution) {
        if (i == length) {
            solution.add(cur);
            return;
        }
        int num = digit.charAt(i) - '0';
        Character[] arr = mapper.get(num);
        for (Character ch : arr) {
            letterCombinationsHelper(digit, i + 1, length, cur + ch, mapper, solution);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        ArrayList<String> solution = new Q42_LetterCombinationPhoneNum().letterCombinationsMy(digits);
        for (Iterator<String> it = solution.iterator(); it.hasNext();) {
            String string = it.next();
            System.out.println(string);
        }

        String digits_test = TestUtil.generateArrayString(9, 100);
        long l1 = System.currentTimeMillis();
        ArrayList<String> solution1 = new Q42_LetterCombinationPhoneNum().letterCombinations(digits_test);
        long l2 = System.currentTimeMillis();
        ArrayList<String> solution2 = new Q42_LetterCombinationPhoneNum().letterCombinationsEx(digits_test);
        long l3 = System.currentTimeMillis();
        long span1 = l2 - l1, span2 = l3 - l2;
        System.out.println(solution1.size() + " Cost " + span1);
        System.out.println(solution2.size() + " Cost " + span2);
    }

    //my way
    public ArrayList<String> letterCombinationsMy(String digits) {
        ArrayList<String>[] solutions = new ArrayList[2];
        solutions[0] = new ArrayList<>();
        solutions[1] = new ArrayList<>();
        HashMap<Integer, Character[]> mapper = new HashMap<>();
        mapper.put(0, new Character[]{'@'});
        mapper.put(1, new Character[]{'$'});
        mapper.put(2, new Character[]{'a', 'b', 'c'});
        mapper.put(3, new Character[]{'d', 'e', 'f'});
        mapper.put(4, new Character[]{'g', 'h', 'i'});
        mapper.put(5, new Character[]{'j', 'k', 'l'});
        mapper.put(6, new Character[]{'m', 'n', 'o'});
        mapper.put(7, new Character[]{'p', 'q', 'r', 's'});
        mapper.put(8, new Character[]{'t', 'u', 'v'});
        mapper.put(9, new Character[]{'w', 'x', 'y', 'z'});
        int len = digits.length(), i;
        for (i = 0; i < len; i++) {
            ArrayList<String> cur = solutions[i % 2];
            ArrayList<String> pre = solutions[(1 + i) % 2];
            cur.clear();
            char ch = digits.charAt(i);
            Character[] char_list = mapper.get(ch - '0');
            if (pre.isEmpty()) {
                for (Character character : char_list) {
                    cur.add(String.valueOf(character));
                }
            } else {
                for (String string : pre) {
                    for (Character character : char_list) {
                        cur.add(String.valueOf(string + character));
                    }
                }
            }
        }
        return solutions[(i + 1) % 2];
    }
}
