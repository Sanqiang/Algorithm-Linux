/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package LeetCode.OnlineJudge;

import com.sun.org.apache.xml.internal.serializer.ToTextSAXHandler;
import java.util.ArrayList;
import sun.reflect.generics.tree.IntSignature;

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
        ArrayList<String> solution = new Q110_TextJustification().fullJustifyMy(words, L);
        for (String string : solution) {
            System.out.println(string);
        }
    }

    public ArrayList<String> fullJustifyMy(String[] words, int L) {
        ArrayList<String> solution = new ArrayList<>();
        int s = 0, count = words[0].length();
        for (int i = 1; i < words.length; i++) {
            count += 1 + words[i].length();
            if (count > L) {
                String temp = generateLine(words, s, i - 1, L);
                s = i;
                count = 0;
                solution.add(temp);
            }
        }
        if (s <= words.length - 1) {
            String temp = generateLine(words, s, words.length - 1, L);
            solution.add(temp);
        }
        return solution;
    }

    String generateLine(String[] words, int s, int e, int L) {
        StringBuilder sb = new StringBuilder();
        int word_num = e - s + 1, total_empty = L;
        if (word_num > 1) {
            for (int i = s; i <= e; i++) {
                total_empty -= words[i].length();
            }
            int per_empty = total_empty / (word_num - 1);
            int per_empty_offset = total_empty % (word_num - 1);
            for (int i = s; i <= e; i++) {
                sb.append(words[i]);
                if (i == s) {
                    for (int count = 0; count < per_empty + per_empty_offset; count++) {
                        sb.append("_");
                    }
                } else if (i <= e - 1) {
                    for (int count = 0; count < per_empty; count++) {
                        sb.append("_");
                    }
                }
            }
        } else if (word_num == 1) {
            sb.append(words[s]);
            for (int count = 0; count < L - words[s].length(); count++) {
                sb.append("_");
            }
        }
        return sb.toString();
    }
}
