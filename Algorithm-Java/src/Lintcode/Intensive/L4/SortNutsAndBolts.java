package Lintcode.Intensive.L4;

import java.util.Iterator;

class NBComparator {
	public int cmp(String a, String b) {
		return -1;
	}
}

public class SortNutsAndBolts {

	/**
	 * @param nuts:
	 *            an array of integers
	 * @param bolts:
	 *            an array of integers
	 * @param compare:
	 *            a instance of Comparator
	 * @return: nothing
	 */
	public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
		if (nuts == null || bolts == null || nuts.length == 0 || bolts.length == 0 || nuts.length != bolts.length) {
			return;
		}
		qsort(nuts, bolts, compare, 0, nuts.length - 1);
	}

	void qsort(String[] nuts, String[] bolts, NBComparator compare, int start, int end) {
		while (start < end) {
			int pivot_idx = partition(nuts, bolts[start], start, end, compare);
			partition(bolts, nuts[pivot_idx], start, end, compare);

			qsort(nuts, bolts, compare, start, pivot_idx - 1);
			qsort(nuts, bolts, compare, pivot_idx + 1, end);
		}
	}

	int partition(String[] target_array, String pivot, int start, int end, NBComparator compare) {
		for (int i = start; i <= end; i++) {
			if (compare.cmp(pivot, target_array[i]) == 0 || compare.cmp(target_array[i], pivot) == 0) {
				swap(target_array, i, start);
				break;
			}
		}

		String target_pivot = target_array[start];
		while (start < end) {
			while (start < end
					&& (compare.cmp(target_array[end], pivot) == -1 || compare.cmp(pivot, target_array[end]) == 1)) {
				--end;
			}
			target_array[start] = target_array[end];

			while (start < end && (compare.cmp(target_array[start], pivot) == 1
					|| compare.cmp(pivot, target_array[start]) == -1)) {
				++start;
			}
			target_array[end] = target_array[start];
		}
		target_array[start] = target_pivot;
		return start;
	}

	void swap(String[] target_array, int i, int j) {
		String temp = target_array[i];
		target_array[i] = target_array[j];
		target_array[j] = temp;
	}
}
