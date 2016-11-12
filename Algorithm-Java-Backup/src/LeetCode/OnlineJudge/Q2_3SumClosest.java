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

    //My way actually the correct way
    public int threeSumClosestEx(int[] num, int target) {
        java.util.Arrays.sort(num);
        int cloest = Integer.MAX_VALUE;
        int i, length = num.length;
        for (i = 0; i < length - 3; i++) {
            int s = i + 1;
            int e = length - 1;
            while (s < e) {
                int sum = Math.abs(num[i] + num[s] + num[e]);
                if (sum == target) {
                    return 0;
                } else if (sum < target) {
                    ++s;
                } else if (sum > target) {
                    --e;
                }

                int temp = Math.abs(sum - target);
                cloest = Math.min(cloest, temp);
            }
        }
        return cloest;
    }

    public static void main(String[] args) {
        int[] num = {-1, 2, 1, -4};
        int SmallestDistance = new Q2_3SumClosest().threeSumClosestEx(num, 1);
        System.out.print(SmallestDistance);
    }
}
