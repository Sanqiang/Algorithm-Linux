/**
 * Sanqiang Zhao Www.131X.Com Dec 29, 2012
 */
package CareerCup.Moderate;

public class Q17_6_FindMNToBeSorted {

    public int findEndOfLeftSubsequence(int[] arr) {
        int i, length = arr.length;
        for (i = 1; i < length; i++) {
            if (arr[i] < arr[i - 1]) {
                break;
            }
        }
        return i - 1;
    }

    public int findStartOfRightSubsequence(int[] arr) {
        int i, length = arr.length;
        for (i = length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                break;
            }
        }
        return i + 1;
    }

    public int shrinkLeft(int[] arr, int min_index, int start) {
        int comp = arr[min_index], i;
        for (i = start - 1; i >= 0; --i) {
            if (arr[i] <= comp) {
                return i + 1;
            }
        }
        return 0;
    }

    public int shrinkRight(int[] arr, int max_index, int start) {
        int comp = arr[max_index], i, length = arr.length;
        for (i = start + 1; i < length - 1; i++) {
            if (arr[i] >= comp) {
                return i - 1;
            }
        }
        return length - 1;
    }

    public void findMN(int[] arr) {
        int length = arr.length, i;
        int end_left = findEndOfLeftSubsequence(arr);
        int start_right = findStartOfRightSubsequence(arr);

        int max_index = start_right - 1;
        int min_index = end_left + 1;
        if (min_index == length || max_index < 0) {
            return;
        }
        for (i = end_left; i <= start_right; i++) {
            if (arr[i] > arr[max_index]) {
                max_index = i;
            }
            if (arr[i] < arr[min_index]) {
                min_index = i;
            }
        }
        int m = shrinkLeft(arr, min_index, end_left);
        int n = shrinkRight(arr, max_index, start_right);
        System.out.println("m:" + m + " n:" + n);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        new Q17_6_FindMNToBeSorted().findMN(arr);
    }
}
