/**
 * Sanqiang Zhao Www.131X.Com Jan 27, 2013
 */
package haimenboy;

public class Q26_LongestPalidrome {

    String longest(String input) {
        int len = input.length(), max_len = 0, max_start = 0, cur_len = 0;
        for (int mid = 0; mid < len; mid++) {
            int l = mid - 1;
            int r = mid + 1;
            while (l >= 0 && r < len) {
                if (input.charAt(l) != input.charAt(r)) {
                    cur_len = r - l + 1;
                    if (cur_len > max_len) {
                        max_len = cur_len - 2;
                        max_start = l + 1;
                    }
                    break;
                }
                --l;
                ++r;
            }
            cur_len = r - l + 1;
            if (cur_len > max_len) {
                max_len = cur_len - 2;
                max_start = l + 1;
            }
            l = mid;
            r = mid + 1;
            while (l >= 0 && r < len) {
                if (input.charAt(l) != input.charAt(r)) {
                    cur_len = r - l + 1;
                    if (cur_len > max_len) {
                        max_len = cur_len - 2;
                        max_start = l + 1;
                    }
                    break;
                }
                cur_len = r - l + 1;
                if (cur_len > max_len) {
                    max_len = cur_len - 2;
                    max_start = l + 1;
                }
                --l;
                ++r;
            }
        }
        return input.substring(max_start, max_start + max_len);
    }

    public static void main(String[] args) {
        String input = "EGHGABCBAEE";
        String output = new Q26_LongestPalidrome().longest(input);
        System.out.println(output);
    }
}
