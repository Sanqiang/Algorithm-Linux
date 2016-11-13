package Lintcode.Intensive.L1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class TwoSum {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> num2idx = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
			int num = numbers[i];
			if (num2idx.containsKey(target - num)) {
				int[] result = new int[2];
				result[1] = i+1;
				result[0] = num2idx.get(target - num);
				return result;
			}
			num2idx.put(num, i+1);
		}
        
        return null;
    }
    
    /*
     * The index solution
     */
    class Num{
    	int num;
    	int idx;
    	
    	public Num(int num, int idx) {
    		this.num = num;
    		this.idx = idx;
		}
    }
    
    public int[] twoSum2(int[] numbers, int target) {
    	ArrayList<Num> nums = new ArrayList<>();
    	for (int i = 0; i < numbers.length; i++) {
			Num num = new Num(numbers[i], i+1);
			nums.add(num);
		}
    	Collections.sort(nums, new Comparator<Num>() {
			@Override
			public int compare(Num o1, Num o2) {
				return o1.num - o2.num;
			}
		});
    	int i = 0, j = numbers.length - 1;
    	while (i < j) {
			Num num_i = nums.get(i), num_j = nums.get(j);
    		if (num_i.num+num_j.num < target) {
				++i;
			}else if(num_i.num+num_j.num > target){
				--j;
			}else{
				int[] result = new int[2];
				result[0] = num_i.idx < num_j.idx?num_i.idx:num_j.idx;
				result[1] = num_i.idx > num_j.idx?num_i.idx:num_j.idx;
				return result;
			}
		}
    	return null;
    }
    
    /*
     * two sum extension larger
     */
    public int[] twoSumLarger(int[] numbers, int target) {
    	ArrayList<Num> nums = new ArrayList<>();
    	for (int i = 0; i < numbers.length; i++) {
			Num num = new Num(numbers[i], i+1);
			nums.add(num);
		}
    	Collections.sort(nums, new Comparator<Num>() {
			@Override
			public int compare(Num o1, Num o2) {
				return o1.num - o2.num;
			}
		});
    	
    	int i = 0, j = numbers.length - 1;
    	while (i < j) {
    		Num num_i = nums.get(i), num_j = nums.get(j);
    		if (num_i.num+num_j.num <= target) {
    			++i;
    		}else{
				int[] result = new int[2];
				result[0] = num_i.idx < num_j.idx?num_i.idx:num_j.idx;
				result[1] = num_i.idx > num_j.idx?num_i.idx:num_j.idx;
				return result;
    		}
    	}
    	
    	return null;
    }
    
    /*
     * two sum extension larger count
     */
    public int twoSumExCnt(int[] numbers, int target) {
    	Arrays.sort(numbers);
    	int cnt = 0;
    	int i = 0, j = numbers.length-1;
    	while (i < j) {
			int num_i = numbers[i], num_j = numbers[j];
			if (num_i + num_j > target) {
				cnt += j-i;
				--j;
			}else{
				i++;
			}
		}
    	return cnt;
    }
    

    
    public static void main(String[] args) {
		if(false){
	    	int[] numbers = {5,4,3,7,8};
			int[] solutions = new TwoSum().twoSumLarger(numbers, 14);
			System.out.println(solutions[0] + "-" + solutions[1]);
		}else if(false){
			int[] numbers = {5,4,3,7,8};
			int cnt = new TwoSum().twoSumExCnt(numbers, 8);
			System.out.println(cnt);
		}

    }
}
