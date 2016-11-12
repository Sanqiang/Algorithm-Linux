/**
 * Sanqiang Zhao Www.131X.Com Dec 20, 2012
 */
package LeetCode.OnlineJudge;

public class Q36_IntegerToRoman {

    String[] D1 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    String[] D10 = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] D100 = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] D1000 = {"M", "MM", "MMM"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 4;
        while (i > 0) {
            int digit = (num / ((int) (Math.pow(10, i) / Math.pow(10, 1)))) % 10;
            if (digit > 0) {
                switch (i) {
                    case 4:
                        sb.append(D1000[digit - 1]);
                        break;
                    case 3:
                        sb.append(D100[digit - 1]);
                        break;
                    case 2:
                        sb.append(D10[digit - 1]);
                        break;
                    case 1:
                        sb.append(D1[digit - 1]);
                        break;
                }
            }
            --i;
        }
        return sb.toString();
    }
    String[] map = {"I", "V", "X", "L", "C", "D", "M"};

    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 4, count = 0;
        while (i > 0) {
            int digit = (num / ((int) (Math.pow(10, i) / Math.pow(10, 1)))) % 10;
            String s1 = "", s2 = "", s3 = "";
            switch (i) {
                case 1:
                    s1 = "I";
                    s2 = "V";
                    s3 = "X";
                    break;
                case 2:
                    s1 = "X";
                    s2 = "L";
                    s3 = "C";
                    break;
                case 3:
                    s1 = "C";
                    s2 = "D";
                    s3 = "M";
                    break;
                case 4:
                    s1 = "M";
                    break;
            }
            if (digit >= 1 && digit <= 3) {
                for (count = 0; count < digit; ++count) {
                    sb.append(s1);
                }
            } else if (digit == 4) {
                sb.append(s1).append(s2);
            } else if (digit >= 5 && digit <= 8) {
                sb.append(s2);
                for (count = 0; count <= digit - 5; ++count) {
                    sb.append(s3);
                }
            } else if (digit == 9) {
                sb.append(s1).append(s3);
            }

            --i;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 3999;
        String text = new Q36_IntegerToRoman().intToRoman(num);
        System.out.println(text);
        String text2 = new Q36_IntegerToRoman().intToRoman2(num);
        System.out.println(text2);
        String text3 = new Q36_IntegerToRoman().intToRomanMy(num);
        System.out.println(text3);
    }

    public String intToRomanMy(int num) {
        StringBuilder sb = new StringBuilder();
        int digit = 1;
        String s1 = "", s2 = "", s3 = "";
        while (num > 0) {
            int c = num % 10;
            switch (digit) {
                case 1:
                    s1 = "I";
                    s2 = "V";
                    s3 = "X";
                    break;
                case 2:
                    s1 = "X";
                    s2 = "L";
                    s3 = "C";
                    break;
                case 3:
                    s1 = "C";
                    s2 = "D";
                    s3 = "M";
                    break;
                case 4:
                    s1 = "M";
                    break;
            }
            if (c <= 3 && c >= 1) {
                for (int i = 0; i < c; i++) {
                    sb.insert(0, s1);
                }
            } else if (c == 4) {
                sb.insert(0, s1 + s2);
            } else if (c >= 5 && c <= 8) {
                for (int i = 0; i < c - 5; i++) {
                    sb.insert(0, s1);
                }
                sb.insert(0, s2);
            } else if (c == 9) {
                sb.insert(0, s1 + s3);
            }
            ++digit;
            num /= 10;
        }
        return sb.toString();
    }
}
