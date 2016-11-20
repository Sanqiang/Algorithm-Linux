package Lintcode.Intensive.L3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import Lintcode.Util.HashHeap;

//todo: not finished
public class BuildingOutline {
	class BuildEntry {
		public int index, height;
		boolean start;

		public BuildEntry(int index, boolean start, int height) {
			this.index = index;
			this.height = height;
			this.start = start;
		}
	}

	class BuildComparator implements Comparator<BuildEntry> {

		@Override
		public int compare(BuildEntry o1, BuildEntry o2) {
			return o1.index - o2.index;
		}

	}

	/**
	 * @param buildings:
	 *            A list of lists of integers
	 * @return: Find the outline of those buildings
	 */
	public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
		if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
			return results;
		}

		ArrayList<BuildEntry> entries = new ArrayList<>();
		for (int i = 0; i < buildings.length; i++) {
			entries.add(new BuildEntry(buildings[i][0], true, buildings[i][2]));
			entries.add(new BuildEntry(buildings[i][1], false, buildings[i][2]));
		}
		Collections.sort(entries, new BuildComparator());

		HashHeap heap = new HashHeap(true);
		BuildEntry pre_entry = null;
		for (int i = 0; i < entries.size(); i++) {
			if (heap.getSize() == 0) {
				pre_entry = entries.get(i);
			} else {
				if (entries.get(i).height > heap.peek()) {
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(pre_entry.index);
					temp.add(entries.get(i).index);
					temp.add(heap.peek());
					results.add(temp);
					pre_entry = entries.get(i);
				}
			}
			if (entries.get(i).start) {
				heap.push(entries.get(i).height);
			} else {
				int temp_height = entries.get(i).height;
				heap.delete(temp_height);
				if (heap.getSize() == 0 || temp_height > heap.peek()) {
					if(pre_entry.index < entries.get(i).index){
						ArrayList<Integer> temp = new ArrayList<>();
						temp.add(pre_entry.index);
						temp.add(entries.get(i).index);
						temp.add(temp_height);
						results.add(temp);
					}
					
					if (temp_height > heap.peek()) {
						pre_entry = entries.get(i);
					}
				}

			}
		}

		return results;
	}

	public static void main(String[] args) {
		int[][] buildings = { { 1, 3, 3 }, { 2, 4, 4 }, { 5, 6, 1 } };
		new BuildingOutline().buildingOutline(buildings);
	}
}
