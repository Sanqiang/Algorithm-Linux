/**
 * Sanqiang Zhao Www.131X.Com Dec 26, 2012
 */
package LeetCode.OnlineJudge;

public class Q114_UniqueBinarySearchTree {

    public int numTrees(int n) {
        return numTreesHelper(1, n);
    }

    private int numTreesHelper(int s, int e) {
        if (s >= e) {
            return 1;
        }
        int ways = 0, left = 0, right = 0;
        for (int i = s; i <= e; i++) {
            left = numTreesHelper(s, i - 1);
            right = numTreesHelper(i + 1, e);
            ways += left * right;
        }
        return ways;
    }

    public static void main(String[] args) {
        int n = 3;
        int ways = new Q114_UniqueBinarySearchTree().numTreesMy(n);
        System.out.println(ways);
    }

    public int numTreesMy(int n) {
        return numTreeHelper(1, n);
    }

    int numTreeHelper(int s, int e) {
        if (s > e) {
            return 1;
        }
        int ways = 0, l = 0, r = 0;
        for (int i = s; i <= e; i++) {
            l = numTreeHelper(s, i - 1);
            r = numTreeHelper(i + 1, e);
            ways += l * r;
        }
        return ways;
    }
}
