/**
 * Sanqiang Zhao Www.131X.Com Dec 20, 2012
 */
package LeetCode.OnlineJudge;

import Util.TestUtil;

public class Q34_StrStr {

    final String ErrorMessage = "Not Found!!!";

    public String strStr(String haystack, String needle) {
        int[] mapper = next(needle);
        int i = 0, pos = 0, haystack_length = haystack.length(), needle_length = needle.length();
        while (i < haystack_length) {
            while (haystack.charAt(i) == needle.charAt(pos)) {
                ++i;
                ++pos;
                if (pos == needle_length) {
                    return haystack.substring(i - needle_length);
                }
                if (i == haystack_length) {
                    return ErrorMessage;
                }
            }
            if (pos > 0) {
                pos = mapper[pos - 1];
            } else {
                pos = 0;
            }
            ++i;
        }
        return ErrorMessage;
    }

    private int[] next(String needle) {
        int length = needle.length(), pos = 0, i = 1;
        int[] mapper = new int[length];
        while (i < length) {
            if (needle.charAt(i) == needle.charAt(pos)) {
                ++pos;
                mapper[i] = pos;
                ++i;
            } else {
                if (pos > 0) {
                    --pos;
                } else {
                    mapper[i] = pos;
                    ++i;
                }
            }
        }
        return mapper;
    }

    public String strStrEx(String haystack, String needle) {
        int[] mapper = nextEx(needle);
        int i = 1, pos = 0, haystack_length = haystack.length(), needle_length = needle.length();
        while (i < haystack_length) {
            while (haystack.charAt(i) == needle.charAt(pos)) {
                ++i;
                ++pos;
                if (pos == needle_length) {
                    return haystack.substring(i - needle_length);
                }
                if (i == haystack_length) {
                    return ErrorMessage;
                }
            }
            if (pos > 0) {
                pos = mapper[pos - 1];
            } else {
                pos = 0;
            }
            ++i;
        }
        return "";
    }

    private int[] nextEx(String needle) {
        int length = needle.length(), i;
        int[] mapper = new int[length];
        int[] code = new int[0xff];
        for (i = 0; i < length; ++i) {
            char c = needle.charAt(i);
            if (code[c] == 0) {
                code[c] = i;
                mapper[i] = 0;
            } else {
                mapper[i] = code[c];
                code[c] = i;
            }
        }
        return mapper;
    }

    public static void main(String[] args) {
        String haystack = "1334123123";
        String needle = "123123";
        String str = new Q34_StrStr().strStr(haystack, needle);
        System.out.println(str);
        String str2 = new Q34_StrStr().strStrEx(haystack, needle);
        System.out.println(str2);

        String haystack_test = TestUtil.generateArrayString(65535000, 9);
        String needle_test = TestUtil.generateArrayString(500, 9);;
        int count = 1;
        long span1 = 0, span2 = 0;
        while (count-- > 0) {
            long l1 = System.currentTimeMillis();
            String t1 = new Q34_StrStr().strStr(haystack, needle);
            long l2 = System.currentTimeMillis();
            String t2 = new Q34_StrStr().strStrEx(haystack, needle);
            long l3 = System.currentTimeMillis();
            span1 += (l2 - l1);
            span2 += (l3 - l2);
        }
        System.out.println("KMP:" + span1);
        System.out.println("ZSQ:" + span2);
    }
}
