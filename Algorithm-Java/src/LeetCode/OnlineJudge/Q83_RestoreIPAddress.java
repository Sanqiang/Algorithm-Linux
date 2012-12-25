/**
 * Sanqiang Zhao Www.131X.Com Dec 24, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;

public class Q83_RestoreIPAddress {

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> solution = new ArrayList<>();
        int dot1, dot2, dot3, length = s.length();
        for (dot1 = 1; dot1 < length; ++dot1) {
            for (dot2 = dot1 + 1; dot2 < length; ++dot2) {
                for (dot3 = dot2 + 1; dot3 < length; ++dot3) {
                    if (isValidate(s.substring(0, dot1))
                            && isValidate(s.substring(dot1, dot2))
                            && isValidate(s.substring(dot2, dot3))
                            && isValidate(s.substring(dot3, length - 1))) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(s.substring(0, dot1)).append(".").append(s.substring(dot1, dot2))
                                .append(".").append(s.substring(dot2, dot3)).append(".").append(s.substring(dot3, length - 1));
                        solution.add(sb.toString());
                    }
                }
            }
        }
        return solution;
    }

    private boolean isValidate(String ip) {
        int length = ip.length();
        if (length > 3) {
            return false;
        }
        if (length == 3) {
            return ip.charAt(0) >= '1' && ip.charAt(0) <= '2'
                    && ip.charAt(1) >= '0' && ip.charAt(1) <= '9'
                    && ip.charAt(2) >= '0' && ip.charAt(2) <= '9';
        } else if (length == 2) {
            return ip.charAt(0) >= '1' && ip.charAt(0) <= '9'
                    && ip.charAt(1) >= '0' && ip.charAt(1) <= '9';
        } else {
            return ip.charAt(0) >= '1' && ip.charAt(0) <= '9';
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        ArrayList<String> solution = new Q83_RestoreIPAddress().restoreIpAddresses(s);
        for (String string : solution) {
            System.out.println(string);
        }
   
    }
}
