/**
 * Sanqiang Zhao Www.131X.Com Jan 24, 2013
 */
package haimenboy;

public class Q13_2Sum {

    void printSum(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            if (nums[s] + nums[e] == target) {
                System.out.println(nums[s] + "+" + nums[e]);
                ++s;
                --e;
            } else if (nums[s] + nums[e] > target) {
                --e;
            } else {
                ++s;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,6,7,8,9,10};
        int target = 12;
        new Q13_2Sum().printSum(nums, 12);
    }
}
