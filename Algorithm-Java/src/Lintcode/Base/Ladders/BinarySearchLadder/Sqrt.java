package Lintcode.Base.Ladders.BinarySearchLadder;

public class Sqrt {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
    	long start = 0, end = x;
    	while(start + 1 < end){
    		long mid = start + (end - start) / 2;
    		if(mid*mid <= x){
    			start = mid;
    		}else if(mid*mid > x){
    			end = mid;
    		}
    	}
    	
    	if (end * end == x){
    		return (int) end;
    	}else {
    		return (int) start;
    	}
    }
}
