package Lintcode.Intensive.L4;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class KthLargestElement {
	/*
	 * @param k : description of k
	 * 
	 * @param nums : array of nums
	 * 
	 * @return: description of return
	 */
	public int kthLargestElement(int k, int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int pivot, start = 0, end = nums.length - 1, pre_start = 0, pre_end = nums.length - 1;

		while (true) {
			pivot = nums[start];
			pre_start = start;
			pre_end = end;
			while (start < end) {
				for (; start < end && nums[end] <= pivot;)
					--end;
				nums[start] = nums[end];

				for (; start < end && nums[start] >= pivot;)
					++start;
				nums[end] = nums[start];
			}
			nums[start] = pivot;
			
			if (start == k - 1) {
				return nums[start];
			}else if(start < k - 1){
				start = start + 1;
				end = pre_end;
			}else{
				end = start - 1;
				start = pre_start;
			}
		}
	
	}
	
	public static void main(String[] args) {
		int[] nums = {9,3,2,4,8};
		System.out.println(new KthLargestElement().kthLargestElement(3, nums));
	}
}
