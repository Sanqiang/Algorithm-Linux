package Lintcode.Base.Ladders.IntegerArrayLadder;

import java.util.ArrayList;

public class ProductExcludeItself {
	/**
	 * @param A:
	 *            Given an integers array A
	 * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... *
	 *          A[n-1]
	 */
	public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
		ArrayList<Long> result = new ArrayList<>();
		if(A.size() == 1){
			result.add(1l);
			return result;
		}
		long[] left_product = new long[A.size()], right_product = new long[A.size()];
		long base = 1l;
		for (int i = 0; i < A.size(); ++i) {
			base *= A.get(i);
			left_product[i] = base;
		}
		base = 1;
		for (int i = A.size() - 1; i >= 0; --i) {
			base *= A.get(i);
			right_product[i] = base;
		}

		
		for (int i = 0; i < A.size(); ++i) {
			if (i == 0) {
				result.add(right_product[i + 1]);
			} else if (i == A.size() - 1) {
				result.add(left_product[i - 1]);
			} else {
				result.add(left_product[i - 1] * right_product[i + 1]);
			}
		}
		return result;
	}
}
