package Lintcode.Intensive.L1;

import java.util.Arrays;

import org.jcp.xml.dsig.internal.dom.DOMKeyInfoFactory;

public class ThreeSumClosest {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
    	Arrays.sort(numbers);
        int sum = 0, min = Integer.MAX_VALUE;
        
        for (int k = numbers.length-1; k >= 0; k--) {
			int num_k = numbers[k];
			int target_k = target - num_k;
			
			int i = 0, j = k-1;
			while (i < j) {
				int num_i = numbers[i], num_j = numbers[j];
				int diff = Math.abs(num_i+num_j+num_k-target);
				if (diff < min) {
					min = diff;
					sum = num_i+num_j+num_k;
				}
				if (num_i + num_j < target_k) {
					i++;
				}else if(num_i + num_j > target_k){
					j--;

				}else{
					return sum;
				}
			}
		}
        
        return sum;
    }
}
