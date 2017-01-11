package Lintcode.Base.Ladders.BinaryTreeLadder;

public class NumTrees {
	/**
	 * @paramn n: An integer
	 * @return: An integer
	 */
	public int numTrees(int n) {
		int[] tab = new int[1 + n];
		tab[0] = 1;
		tab[1] = 1;
		for (int i = 2; i <= n; ++i) {
			int cnt = 0;
			for (int left = 0; left <= n; ++left) {
				int right = n - left;
				cnt += tab[left] * tab[right];
			}
			tab[i] = cnt;
		}

		return tab[n];
	}
}
