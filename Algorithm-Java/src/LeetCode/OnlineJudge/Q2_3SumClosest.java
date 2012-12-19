/**
 * Sanqiang Zhao Www.131X.Com Dec 17, 2012
 */
package LeetCode.OnlineJudge;

public class Q2_3SumClosest {

    public int threeSumClosest(int[] num, int target) {
        java.util.Arrays.sort(num);
        int length = num.length, l = 0, r = length - 1, m = l + 1;
        int SmallestDistance = Integer.MAX_VALUE;
        while (r - l > 1) {
            int current_sum = num[l] + num[r];
            if (current_sum > target) {
                m = l + 1;
            } else if (current_sum < target) {
                m = r - 1;
            }
            current_sum += num[m];
            int CurrentDistance = Math.abs(current_sum - target);
            if (CurrentDistance < SmallestDistance) {
                SmallestDistance = CurrentDistance;
            }
            if (current_sum == target) {
                return 0;
            } else if (current_sum > target) {
                --r;
                /*if (r == m) {
                 --m;
                 }*/
            } else {
                ++l;
                /*if (l == m) {
                 ++m;
                 }*/
            }
        }

        return SmallestDistance;
    }

    public static void main(String[] args) {
        int[] num = {-1, 2, 1, -4};
        int SmallestDistance = new Q2_3SumClosest().threeSumClosest(num, 1);
        System.out.print(SmallestDistance);
    }
}
