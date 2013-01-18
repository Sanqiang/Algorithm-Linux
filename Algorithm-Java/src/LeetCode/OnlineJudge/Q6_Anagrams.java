/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;
import java.util.HashMap;

public class Q6_Anagrams {

    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> solutions = new ArrayList<>();
        HashMap<String, ArrayList<String>> temp = new HashMap<>();


        for (String str : strs) {
            String key = sortChars(str);
            if (!temp.containsKey(key)) {
                ArrayList<String> temp_list = new ArrayList<>();
                temp.put(key, temp_list);
            }
            ArrayList<String> temp_list = temp.get(key);
            temp_list.add(str);
        }

        for (String temp_key : temp.keySet()) {
            if (temp.get(temp_key).size() >= 2) {
                solutions.addAll(temp.get(temp_key));
            }
        }

        return solutions;
    }

    String sortChars(String str) {
        char[] arr = str.toCharArray();
        java.util.Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
    }
}
