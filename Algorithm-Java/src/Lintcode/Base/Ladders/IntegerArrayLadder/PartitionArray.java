package Lintcode.Base.Ladders.IntegerArrayLadder;

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

		int start = 0, end = nums.length - 1;
		while (start <= end) {
			while (start <= end && nums[start] < k) {
				++start;
			}

			while (start <= end && nums[end] >= k) {
				--end;
			}

			if (start <= end && start < nums.length && end >= 0 && start != end) {
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
				++start;
				--end;
			}
		}
		
		return start;
	}
}
