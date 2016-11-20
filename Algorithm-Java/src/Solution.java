import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
	class HeapNode {
		int pos_;
		int cnt_;

		public HeapNode(int pos, int cnt) {
			this.pos_ = pos;
			this.cnt_ = cnt;
		}
	}

	class HashHeap {

		private ArrayList<Integer> heap_;
		private HashMap<Integer, HeapNode> hash_;
		private boolean is_max_;
		private int size_;

		public HashHeap(boolean is_max) {
			this.heap_ = new ArrayList<Integer>();
			this.hash_ = new HashMap<Integer, HeapNode>();
			this.is_max_ = is_max;
		}

		// ==============================implementation
		// functions==============================//

		public void push(int value) {
			if (this.hash_.containsKey(value)) {
				HeapNode node = this.hash_.get(value);
				node.cnt_++;
			} else {
				this.heap_.add(value);
				this.hash_.put(value, new HeapNode(this.heap_.size() - 1, 1));
				rise(this.heap_.size() - 1);
			}
			++this.size_;
		}

		public int poll() {
			int value = this.heap_.get(0);
			HeapNode node = this.hash_.get(value);
			if (node.cnt_ == 1) {
				swap(0, this.heap_.size() - 1);
				this.heap_.remove(this.heap_.size() - 1);
				this.hash_.remove(value);
				sink(0);
			} else {
				node.cnt_--;
			}
			--this.size_;
			return value;
		}

		public int peek() {
			int value = this.heap_.get(0);
			return value;
		}

		public void delete(int value) {
			HeapNode node = this.hash_.get(value);
			if (node.cnt_ == 1) {
				int idx = node.pos_;
				swap(idx, this.heap_.size() - 1);
				this.hash_.remove(value);
				this.heap_.remove(this.heap_.size() - 1);
				if (idx == heap_.size() - 1) {
					rise(idx);
					sink(idx);
				}
			} else {
				node.cnt_--;
			}
			--this.size_;
		}

		public int getSize() {
			return this.size_;
		}

		public void sink(int idx) {
			while (true) {
				int left_idx = getLeftChild(idx);
				int right_idx = getRightChild(idx);
				int son_idx = idx;
				if (left_idx < this.heap_.size() && isPrior(left_idx, idx)) {
					son_idx = left_idx;
				}
				if (right_idx < this.heap_.size() && isPrior(right_idx, idx)) {
					son_idx = right_idx;
				}
				if (son_idx == idx) {
					break;
				} else {
					swap(son_idx, idx);
				}
			}
		}

		public void rise(int idx) {
			while (getParent(idx) != idx) {
				int parent_idx = getParent(idx);
				if (isPrior(idx, parent_idx)) {
					swap(idx, parent_idx);
					idx = parent_idx;
				} else {
					break;
				}
			}
		}

		// ==============================helper
		// functions==============================//
		public int getLeftChild(int i) {
			return i * 2 + 1;
		}

		public int getRightChild(int i) {
			return i * 2 + 2;
		}

		public int getParent(int i) {
			return (i - 1) / 2;
		}

		public void swap(int i, int j) {
			int temp = heap_.get(i);
			heap_.set(i, heap_.get(j));
			heap_.set(j, temp);

			HeapNode node_i = hash_.get(i), node_j = hash_.get(j);
			hash_.put(j, node_j);
			hash_.put(i, node_i);
		}

		public boolean isPrior(int left, int right) {
			if (this.is_max_) {
				return heap_.get(left) >= heap_.get(right);
			} else {
				return heap_.get(left) <= heap_.get(right);
			}
		}
	}

	/**
	 * @param buildings:
	 *            A list of lists of integers
	 * @return: Find the outline of those buildings
	 */
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
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
			return results;
		}

		ArrayList<BuildEntry> entries = new ArrayList<BuildEntry>();
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
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(pre_entry.index);
					temp.add(entries.get(i).index);
					temp.add(heap.peek());
					results.add(temp);
					pre_entry = entries.get(i);
				}
				if (entries.get(i).start) {
					heap.push(entries.get(i).height);
				} else {
					int temp_height = entries.get(i).height;
					heap.delete(temp_height);
					if (heap.getSize() == 0) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(pre_entry.index);
						temp.add(entries.get(i).index);
						temp.add(temp_height);
						results.add(temp);
					}
				}
			}
		}

		return results;
	}

}