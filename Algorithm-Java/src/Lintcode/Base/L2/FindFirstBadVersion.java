package Lintcode.Base.L2;

public class FindFirstBadVersion {
	static class SVNRepo {
		public static boolean isBadVersion(int k) {
			return true;
		}
	}

	/**
	 * @param n:
	 *            An integers.
	 * @return: An integer which is the first bad version.
	 */
	public int findFirstBadVersion(int n) {
		if (n <= 1) {
			return 1;
		}
		int left = 1, right = n;

		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (SVNRepo.isBadVersion(mid)) {
				right = mid;
			} else {
				left = mid;
			}
		}

		if (SVNRepo.isBadVersion(right) && !SVNRepo.isBadVersion(left)) {
			return right;
		} else if (SVNRepo.isBadVersion(right) && SVNRepo.isBadVersion(left)) {
			return left;
		} else {
			return left;
		}
	}
}
