/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package LeetCode.OnlineJudge;

public class Q96_SearchInsertPosition {

    public int searchInsert(int[] A, int target) {
        int s = 0, length = A.length, e = length - 1, m;
        while (s < e) {
            m = s + (e - s) / 2;
            if (A[m] == target) {
                return m;
            } else if (A[m] < target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int A[] = {1, 3, 5, 7, 9, 11};
        int pos = new Q96_SearchInsertPosition().searchInsertMy(A, 2);
        System.out.println(pos);
    }

    //remind: default in the left
    public int searchInsertMy(int[] A, int target) {
        int s = 0, len = A.length, e = len - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (A[m] == target) {
                return m;
            } else if (A[m] < target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        return s;
    }
}
