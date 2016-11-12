package Lintcode.Intensive.L1;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
    	ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
    	
    	Arrays.sort(numbers);
    	for (int k = numbers.length-1; k >= 0; k--) {
			int num_k = numbers[k];
			int i = 0, j = k-1;
			while (i < j) {
				int num_i = numbers[i], num_j = numbers[j];
				if(num_i + num_j + num_k > 0){
					j--;
				}else if(num_i + num_j + num_k < 0){
					i++;
				}else{
					ArrayList<Integer> solution = new ArrayList<Integer>();
					solution.add(num_i);
					solution.add(num_j);
					solution.add(num_k);
					solutions.add(solution);
					while (i+1<j && numbers[i+1] == num_i) {
						i++;
					}
					while (i<j-1 && numbers[j-1] == num_j) {
						j--;
					}
				}
			}
    	}
    	return solutions;
    }
}
