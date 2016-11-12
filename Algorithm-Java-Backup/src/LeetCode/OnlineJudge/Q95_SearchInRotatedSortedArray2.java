/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package LeetCode.OnlineJudge;

public class Q95_SearchInRotatedSortedArray2 {

    public static void main(String[] args) {
        int[] A = {4, 4, 4, 1, 2, 3, 4, 4, 4};
        int target = 2;
        boolean result = new Q95_SearchInRotatedSortedArray2().searchMy(A, target, 0, A.length-1);
        System.out.println(result);
    }

    public boolean searchMy(int[] A, int target, int s, int e) {
        if (s > e) {
            return false;
        }
        int m = s + (e - s) / 2;
        if (A[m] == target || A[s] == target || A[e] == target) {
            return true;
        }
        if (A[s] < A[m]) {
            if (target > A[s] && target < A[m]) {
                return searchMy(A, target, s, m - 1);
            } else {
                return searchMy(A, target, m + 1, e);
            }
        } else if (A[s] > A[m]) {
            if (target > A[m] && target < A[e]) {
                return searchMy(A, target, m + 1, e);
            } else {
                return searchMy(A, target, s, m - 1);
            }
        } else {
            if (A[m] != A[e]) {
                return searchMy(A, target, m + 1, e);
            } else {
                if (searchMy(A, target, s, m - 1)) {
                    return true;
                } else {
                    return searchMy(A, target, m + 1, e);
                }
            }
        }
    }
}
