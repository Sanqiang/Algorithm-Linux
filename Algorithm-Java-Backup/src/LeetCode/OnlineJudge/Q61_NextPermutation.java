/**
 * Sanqiang Zhao Www.131X.Com Dec 22, 2012
 */
package LeetCode.OnlineJudge;

public class Q61_NextPermutation {

    public void nextPermutation(int[] num) {
        int edge = -1;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] <= num[i + 1]) {
                edge = i;
                break;
            }
        }
        if (edge > -1) {
            for (int i = edge + 1; i < num.length; i++) {
                if (num[edge] >= num[i]) {
                    swap(num, edge, i - 1);
                    break;
                }
                if (i == num.length - 1) {
                    swap(num, edge, i);
                    break;
                }
            }
        }
        for (int i = edge + 1, j = num.length - 1; i <= edge + (num.length - edge - 1) / 2; i++, j--) {
            swap(num, i, j);
        }
    }

    private void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }

    public static void main(String[] args) {
        int num[] = {1, 2, 3, 456, 7, 8};
        new Q61_NextPermutation().nextPermutation(num);
        for (int i : num) {
            System.out.print(i);
        }
    }
}
