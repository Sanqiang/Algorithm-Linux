/**
 * Sanqiang Zhao Www.131X.Com Dec 29, 2012
 */
package CareerCup.Moderate;

public class Q17_8_LargestSum {

    public int sum(int[] arr) {
        int max = arr[0], sum = arr[0], i, length = arr.length;
        for (i = 1; i < length; i++) {
            sum += arr[i];
            if (sum > max) {
                max = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }
        if (max <= 0) {
            for (i = 0; i < length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, -1, 9, -100};
        int sum = new Q17_8_LargestSum().sum(arr);
        System.out.println(sum);
    }
}
