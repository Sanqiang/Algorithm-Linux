/**
 * Sanqiang Zhao Www.131X.Com Jan 2, 2013
 */
package CareerCup.ArraysAndStrings;

public class Q1_8_IsRotate {

    boolean isRotate(String text1, String text2)
    {
        return  (text1+text1).contains(text2);
    }
    
    public static void main(String[] args) {
        Q1_8_IsRotate q1 = new Q1_8_IsRotate();
        boolean result = q1.isRotate("abc", "cab");
        System.out.println(result);
        
    }
}
