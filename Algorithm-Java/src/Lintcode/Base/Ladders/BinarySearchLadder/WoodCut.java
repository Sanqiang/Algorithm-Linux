package Lintcode.Base.Ladders.BinarySearchLadder;

public class WoodCut {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
    	int end = 0;
    	for(int l : L){
    		end = Math.max(end, l);
    	}
    	
    	int start = 1;
    	while (start + 1 < end){
    		int mid = start + (end - start) / 2;
    		int cnt = count(L, mid);
    		if (cnt >= k){
    			start = mid;
    		}else{
    			end = mid;
    		}
    	}
    	
    	if(count(L, end) >= k){
    		return end;
    	}else if(count(L, start) >= k){
    		return start;
    	}else{
    		return 0;
    	}
    }
    
    int count(int[] L, long length){
    	int cnt = 0;
    	for(int l : L){
    		cnt += l / length;
    	}
    	return cnt;
    }
}
