/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;

public class Q110_TextJustification {
    
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> solution = new ArrayList<>();
        int i, length = words.length;
        int char_count = 0, s = 0;
        for (i = 0; i < length; i++) {
            char_count += words[i].length();
            if (char_count + (i - s) > L) {
                char_count -= 1 + words[i].length();
                solution.add(fullJustifyHelper(words, s, i - 1, L));
                char_count = 0;
                s = i;
            }
            if (i == length - 1) {
                solution.add(fullJustifyHelper(words, s, i, L));
            }
        }
        return solution;
    }
    
    private String fullJustifyHelper(String[] words, int s, int e, int L) {
        for (int i = s; i <= e; i++) {
            L -= words[i].length();
        }
        int space = L, space_offset = 0;
        if (e > s) {
            space = L / (e - s);
            space_offset = L % (e - s);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s; i <= e; i++) {
            sb.append(words[i]);
            int size = space;
            if (i == s) {
                size += space_offset;
            } else if (i == e) {
                break;
            }
            for (int j = 0; j < size; j++) {
                sb.append("_");
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String words[] = {"This", "is", "an", "example", "of", "text", "justification."};
        int L = 16;
        ArrayList<String> solution = new Q110_TextJustification().fullJustify(words, L);
        for (String string : solution) {
            System.out.println(string);
        }
    }
}
