/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.SortAndSearch;

public class SortRotatedArray {

    public int find(int[] arr, int s, int e, int target) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return m;
        }
        if (arr[s] < arr[m]) {
            if (target >= arr[s] && target <= arr[m]) {
                return find(arr, s, m - 1, target);
            } else {
                return find(arr, m + 1, e, target);
            }
        } else if (arr[m] < arr[e]) {
            if (target >= arr[m] && target <= arr[e]) {
                return find(arr, m + 1, e, target);
            } else {
                return find(arr, s, m - 1, target);
            }
        } else {
            if (arr[m] != arr[e]) {
                return find(arr, m + 1, e, target);
            } else {
                int f = find(arr, m + 1, e, target);
                if (f == -1) {
                    return find(arr, s, m + 1, target);
                } else {
                    return f;
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}
