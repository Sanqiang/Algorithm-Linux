package Lintcode.Base.Ladders.BinarySearchLadder;

public class FindMin {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] >= nums[start] && nums[mid] >= nums[end]) {
				start = mid;
			} else if (nums[mid] <= nums[start] && nums[mid] <= nums[end]) {
				end = mid;
			} else if (nums[mid] >= nums[start] && nums[mid] <= nums[end]) {
				end = mid;
			} else if (nums[mid] <= nums[start] && nums[mid] >= nums[end]) {
				start = mid;
			}
		}
		
		return Math.min(nums[start], nums[end]);
	}
	
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     * @throws Exception 
     */
    public int findMin2(int[] nums) throws Exception {
		if (nums == null || nums.length == 0) {
			return -1;
		}
    
        throw new Exception("no solution");
    }
}
