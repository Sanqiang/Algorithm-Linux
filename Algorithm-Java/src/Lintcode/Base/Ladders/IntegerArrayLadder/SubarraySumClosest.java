package Lintcode.Base.Ladders.IntegerArrayLadder;

import java.util.ArrayList;
import java.util.Collections;

public class SubarraySumClosest {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
	class Pair implements Comparable{
		public int idx, num;
		
		public Pair(int idx, int num){
			this.idx = idx;
			this.num = num;
		}

		@Override
		public int compareTo(Object o) {
			Pair p = (Pair)o;
			return p.num - this.num;
		}
	}
	
    public int[] subarraySumClosest(int[] nums) {
    	int[] result = new int[2];
    	if (nums == null || nums.length == 0) {
            return result;
        }else if(nums.length == 1){
        	result[0] = result[1] = 0;
        	return result;
        }
    	
    	ArrayList<Pair> pairs = new ArrayList<>(nums.length + 1);
    	pairs.add(new Pair(0, 0));
        int cnt = 0;
        for (int i = 0; i < nums.length; ++i){
        	cnt += nums[i];
        	pairs.add(new Pair(1 + i, cnt));
        }
        
        Collections.sort(pairs);
        
        int min_diff = Integer.MAX_VALUE, min_left = -1, min_right = -1;
        for(int i = 1; i < pairs.size(); ++i){
        	int diff = Math.abs(pairs.get(i).num - pairs.get(i - 1).num);
        	if(diff < min_diff){
        		min_diff = diff;
        		min_left = pairs.get(i).idx - 1;
        		min_right = pairs.get(i - 1).idx - 1;
        	}
        }
        
        if(min_left > min_right){
        	int temp = min_left;
        	min_left = min_right;
        	min_right = temp;
        }
        
        
        result[0] = 1 + min_left;
        result[1] = min_right;
        return result; 
    }
    
    
}
