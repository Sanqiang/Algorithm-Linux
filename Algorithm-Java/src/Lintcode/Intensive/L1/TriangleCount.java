package Lintcode.Intensive.L1;

public class TriangleCount {
    /*
     * triangle count
     */
    public int triangleCount(int S[]) {
		int cnt = 0;
		
		for (int k = S.length-1; k >= 0; k--) {
			int i = 0, j = k-1;
			while (i < j) {
				int num_i = S[i], num_j = S[j];
				if (num_i + num_j > S[k]) {				
					cnt += j-i;
					--j;
				}else{
					i++;
				}
			}	
		}
		
		return cnt;
	}
    
    public static void main(String[] args) {
		int[] S = {4,4,4,4};
		int cnt = new TriangleCount().triangleCount(S);
		System.out.println(cnt);
	}
}
