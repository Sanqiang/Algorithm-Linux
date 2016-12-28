package Lintcode.Base.Ladders.IntegerArrayLadder;

public class MergeSortedArray {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
    	int[] result = new int[A.length + B.length];
        
    	int i = 0, j = 0, k = 0;
    	while(i < A.length && j < B.length){
    		if(A[i] <= B[j]){
    			result[k++] = A[i++];
    		}else{
    			result[k++] = B[j++];
    		}
    	}
    	while(i < A.length){
    		result[k++] = A[i++];
    	}
    	while(j < B.length){
    		result[k++] = B[j++];
    	}
               
        return result;       
    }
}
