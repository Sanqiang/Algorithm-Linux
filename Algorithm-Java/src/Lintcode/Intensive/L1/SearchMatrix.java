package Lintcode.Intensive.L1;

public class SearchMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int cnt = 0, m = matrix.length, n = matrix[0].length;
		int i = 0, j = n-1;
		while (i>=0 && j>=0 && i<m && j<n) {
			if (matrix[i][j] > target) {
				--j;
			}else if (matrix[i][j] < target) {
				++i;
			}else{
				return true;
			}
		}
		return false;
    }
    
    /**
	 * @param matrix:
	 *            A list of lists of integers
	 * @param: A
	 *             number you want to search in the matrix
	 * @return: An integer indicate the occurrence of target in the given matrix
	 */
	public int searchMatrixCnt(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int cnt = 0, m = matrix.length, n = matrix[0].length;
		int i = 0, j = n-1;
		while (i>=0 && j>=0 && i<m && j<n) {
			if (matrix[i][j] > target) {
				--j;
			}else if (matrix[i][j] < target) {
				++i;
			}else{
				cnt++;
				--j;
			}
		}
		return cnt;
	}
}
