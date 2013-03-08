/**
 * Sanqiang Zhao Www.131X.Com Jan 23, 2013
 */
package haimenboy;

public class Q5_ConvertToRational {
    
    String convert(double num) {
        StringBuilder sb = new StringBuilder();
        double divisor, divident = 1;
        while (true) {
            divisor = divident * num;
            if (divisor - (int) divisor == 0) {
                break;
            }
            divident *= 10;
        }
        int gcd = GCD((int) divident, (int) divisor);;
        sb.append((int)divisor / gcd).append("/").append((int)divident / gcd);
        return sb.toString();
    }
    
    int GCD(int a, int b) {
        if (a < b) {
            return GCD(b, a);
        }
        int rem = a % b;
        if (rem == 0) {
            return b;
        }
        return GCD(b, rem);
    }
    
    public static void main(String[] args) {
        double num = 0.124234;
        String rational = new Q5_ConvertToRational().convert(num);
        System.out.println(rational);
    }
}
