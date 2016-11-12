/**
 * Sanqiang Zhao Www.131X.Com Jan 26, 2013
 */
package haimenboy;

public class Q23_MaxSubMatrix {

    int max(int[][] matrix) {
        int max = 0;
        for (int col_s = 0; col_s < matrix.length; col_s++) {
            for (int col_e = col_s; col_e < matrix.length; col_e++) {
                int[] temp = new int[matrix[0].length];
                for (int row = 0; row < matrix[0].length; row++) {
                    int sum = 0;
                    for (int col = col_s; col <= col_e; col++) {
                        sum += matrix[col][row];
                    }
                    temp[row] = sum;
                }
                int cur_max = max(temp);
                max = Math.max(max, cur_max);
            }
        }
        return max;
    }

    int max(int[] arr) {
        int max = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > 0) {
                max = Math.max(max, sum);
            } else {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 0, 3},
            {2, 1, -9, -9},
            {1, -10, -90, -100}
        };
        int max = new Q23_MaxSubMatrix().max(matrix);
        System.out.println(max);
    }
}
