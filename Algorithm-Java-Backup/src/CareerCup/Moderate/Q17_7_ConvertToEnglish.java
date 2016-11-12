/**
 * Sanqiang Zhao Www.131X.Com Dec 29, 2012
 */
package CareerCup.Moderate;

public class Q17_7_ConvertToEnglish {

    final String[] bigs = {"Thousand", "Million", "Billion"};
    final String[] digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    final String[] teens = {"Eleven", "Twelve", "Thirsteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninty"};

    public String convert(int num) {
        StringBuilder sb = new StringBuilder();
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        } else if (num == 0) {
            return "Zero";
        }
        int count = -1;
        while (num > 0) {
            if (count >= 0) {
                sb.insert(0, bigs[count]).insert(0, " ");;
            }
            sb.insert(0, convert100(num % 1000)).insert(0, " ");
            num /= 1000;
            ++count;
        }
        if (negative) {
            sb.insert(0, "Negative ");
        }
        return sb.toString();
    }

    private String convert100(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            sb.append(digits[ num / 100 - 1]).append(" Hundred ");
            num %= 100;
        }
        if (num > 19) {
            sb.append(tens[num / 10 - 1]).append(" ").append(digits[num % 10 - 1]).append(" ");
        } else if (num >= 11) {
            sb.append(teens[num % 10 - 1]).append(" ");
        } else {
            sb.append(digits[num % 10 - 1]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q17_7_ConvertToEnglish q17 = new Q17_7_ConvertToEnglish();
        System.out.println(q17.convert(3111234));
    }
}
