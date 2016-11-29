package Lintcode.Base.L7;

public class SortColors {
	/**
	 * @param nums:
	 *            A list of integer which is 0, 1 or 2
	 * @return: nothing
	 */
	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int left = 0, right = nums.length - 1, idx = 0;
		while (idx <= right) {
			if (nums[idx] == 2) {
				swap(nums, idx, right--);
			}else if(nums[idx] == 0){
				swap(nums, idx++, left++);
			}else if(nums[idx] == 1){
				++idx;
			}
		}
	}

	void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
