/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package LeetCode.OnlineJudge;

public class Q99_SortColors {

    public void sortColorsOneLoop(int[] A) {
        int length = A.length, l = 0, r = length - 1, k = 0;
        while (k <= r) {
            if (A[k] == 2) {
                k++;
            } else if (A[k] == 1) {
                swap(A, l++, k++);
            } else if (A[k] == 3) {
                swap(A, r--, k);
            }
        }
    }

    private void swap(int[] A, int s, int e) {
        int temp = A[s];
        A[s] = A[e];
        A[e] = temp;
    }

    public void sortColorsTwoLoop(int[] A) {
        int tab[] = new int[0xff];
        int i, length = A.length;
        for (i = 0; i < length; ++i) {
            ++tab[A[i]];
        }
        int pos = 0;
        for (i = 0; i < 0xff; ++i) {
            while (tab[i] > 0) {
                A[pos++] = i;
                --tab[i];
            }
        }
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 2, 3, 1, 1, 2, 3};
        new Q99_SortColors().sortColorsMy(A);
        for (int i : A) {
            System.out.print(i);
        }
        System.out.println();
        int A2[] = {1, 2, 3, 2, 3, 1, 1, 2, 3, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1};
        new Q99_SortColors().sortColorsOneLoop(A2);
        for (int i : A2) {
            System.out.print(i);
        }
    }

    public void sortColorsMy(int[] A) {
        int len = A.length, i = 0, j = 0, k = len - 1;
        while (j <= k) {
            if (A[j] == 1) {
                swap(A, i, j);
                ++i;
                ++j;
            } else if (A[j] == 2) {
                ++j;
            } else if (A[j] == 3) {
                swap(A, j, k);
                --k;
            }
        }
    }
}
