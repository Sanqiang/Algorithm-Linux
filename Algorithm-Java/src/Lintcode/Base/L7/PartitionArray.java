package Lintcode.Base.L7;

public class PartitionArray {
	/**
	 * @param nums:
	 *            The integer array you should partition
	 * @param k:
	 *            As description return: The index after partition
	 */
	public int partitionArray(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int left = 0, right = nums.length;

		while (left < right) {
			while (left <= right && nums[right] >= k) {
				--right;
			}

			while (left <= right && nums[left] <= k) {
				++left;
			}

			if (left <= right) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;

				--right;
				++left;
			}

		}

		return left;
	}
}
