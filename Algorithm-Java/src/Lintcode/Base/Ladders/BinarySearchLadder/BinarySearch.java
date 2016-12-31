package Lintcode.Base.Ladders.BinarySearchLadder;

public class BinarySearch {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
        	int mid = start + (end - start) / 2;
        	if (nums[mid] >= target){
        		end = mid;
        	}else{
        		start = mid;
        	}
        }
        
        if(nums[start] == target){
        	return start;
        }else if(nums[end] == target){
        	return end;
        }else{
        	return -1;
        }
    }
}
