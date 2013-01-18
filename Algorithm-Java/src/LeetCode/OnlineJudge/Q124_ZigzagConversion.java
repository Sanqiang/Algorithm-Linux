/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package LeetCode.OnlineJudge;

public class Q124_ZigzagConversion {

    public String convert(String s, int nRows) {
        StringBuilder sb = new StringBuilder();
        int s_length = s.length(), section_per_num = nRows * 2 - 2, k,
                section_size = s_length % section_per_num == 0 ? s_length / section_per_num : s_length / section_per_num + 1;
        for (int r = 0; r < nRows; ++r) {
            for (int sec = 0; sec < section_size; sec++) {
                if (r == 0) {
                    k = sec * section_per_num + r;
                    if (k < s_length) {
                        sb.append(s.charAt(k));
                    }
                } else if (r == nRows - 1) {
                    k = sec * section_per_num + r;
                    if (k < s_length) {
                        sb.append(s.charAt(k));
                    }
                } else {
                    k = sec * section_per_num + r;
                    if (k < s_length) {
                        sb.append(s.charAt(k));
                    }
                    k = sec * section_per_num + r + nRows / 2 + 1;
                    if (k < s_length) {
                        sb.append(s.charAt(k));
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "ABCDEFGHIJKLO";
        int nRows = 3;
        String rotate = new Q124_ZigzagConversion().convertMy(s, nRows);
        System.out.println(rotate);
        String rotate2 = new Q124_ZigzagConversion().convert(s, nRows);
        System.out.println(rotate2);
    }

    public String convertMy(String s, int nRows) {
        StringBuilder sb = new StringBuilder();
        int sector = nRows * 2 - 2, len = s.length(), num_sector = len % sector == 0 ? len / sector : 1 + len / sector;
        for (int pos = 0; pos < nRows; pos++) {
            for (int si = 0; si < num_sector; si++) {
                int cur = si * sector + pos;
                if (cur >= len) {
                    continue;
                }
                if (pos == 0 || pos == nRows - 1) {
                    sb.append(s.charAt(cur));
                } else {
                    sb.append(s.charAt(cur));
                    if (cur + nRows/2+1 >= len) {
                        continue;
                    } else {
                        sb.append(s.charAt(cur + nRows / 2 + 1));
                    }
                }
            }
        }
        return sb.toString();
    }
}
