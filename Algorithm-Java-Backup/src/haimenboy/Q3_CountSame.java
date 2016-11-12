/**
 * Sanqiang Zhao Www.131X.Com Jan 23, 2013
 */
package haimenboy;

import Util.BinaryTreeNode;

public class Q3_CountSame {

    public int countSameInSortedArray(int[] nums, int target, int s, int e) {
        if (e < s) {
            return 0;
        } else if (nums[s] > target) {
            return 0;
        } else if (nums[e] < target) {
            return 0;
        } else if (nums[s] == target && nums[e] == target) {
            return e - s + 1;
        }
        int m = s + (e - s) / 2;
        if (nums[m] == target) {
            return 1 + countSameInSortedArray(nums, target, s, m - 1) + countSameInSortedArray(nums, target, m + 1, e);
        } else if (nums[m] > target) {
            return countSameInSortedArray(nums, target, s, m - 1);
        } else {
            return countSameInSortedArray(nums, target, m + 1, e);
        }
    }

    public int countSameInBST(BinaryTreeNode<Integer> head, int target) {
        if (head == null) {
            return 0;
        }
        if (head.Data == target) {
            return 1 + countSameInBST(head.Left, target) + countSameInBST(head.Right, target);
        } else if (head.Data > target) {
            return countSameInBST(head.Right, target);
        } else {
            return countSameInBST(head.Left, target);
        }
    }

    public static void main(String[] args) {
        Q3_CountSame q3 = new Q3_CountSame();
        int[] nums = {1, 2, 3, 3, 3, 3, 3, 4};
        int count1 = q3.countSameInSortedArray(nums, 3, 0, nums.length-1);
        System.out.println(count1);
        BinaryTreeNode<Integer> head = BinaryTreeNode.getSampleTree4();
        int count2 = q3.countSameInBST(head, 10);
        System.out.println(count2);
    }
}
