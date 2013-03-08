/**
 * Sanqiang Zhao Www.131X.Com Jan 23, 2013
 */
package haimenboy;

public class Q7_FindFirstOccur {

    public int find(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target && (m == 0 || (m - 1 >= 0 && nums[m - 1] != nums[m]))) {
                return m;
            } else if (nums[m] < target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return s;
    }

    public int findSample(int[] nums, int target, int s, int e) {
        if (nums[s] > target) {
            return -1;
        } else if (nums[e] < target) {
            return -1;
        }
        if (nums[s] == target) {
            return s;
        }
        int m = s + (e - s) / 2;
        if (nums[m] == target) {
            int pos = findSample(nums, target, s, m - 1);
            return pos != -1 ? pos : m;
        } else if (nums[m] > target) {
            return findSample(nums, target, s, m - 1);
        } else {
            return findSample(nums, target, m + 1, e);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 3, 3};
        int pos = new Q7_FindFirstOccur().find(nums, 3);
        System.out.println(pos);
        int pos2 = new Q7_FindFirstOccur().findSample(nums, 3, 0, nums.length - 1);
        System.out.println(pos2);
    }
}
