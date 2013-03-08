/**
 * Sanqiang Zhao Www.131X.Com Jan 26, 2013
 */
package haimenboy;

public class Q24_BalancePoint {

    int getPoint(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            left[i] = sum;
        }
        sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i];
            right[i] = sum;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (left[i - 1] == right[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 9, -1, 4};
        int point = new Q24_BalancePoint().getPoint(arr);
        System.out.println(point);
    }
}
