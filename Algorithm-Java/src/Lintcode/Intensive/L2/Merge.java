package Lintcode.Intensive.L2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//class Interval {
//	int start, end;
//
//	Interval(int start, int end) {
//		this.start = start;
//		this.end = end;
//	}
//
//}

//class Entry {
//	public int point;
//	public boolean start;
//
//	public Entry(int point, boolean start) {
//		this.point = point;
//		this.start = start;
//	}
//}

class EntryComparator implements Comparator<Entry>{

	@Override
	public int compare(Entry o1, Entry o2) {
		// TODO Auto-generated method stub
		return o1.point - o2.point;
	}
	
}

public class Merge {
	/**
	 * @param intervals,
	 *            a collection of intervals
	 * @return: A new sorted interval list.
	 */
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals == null || intervals.size() == 0){
			return new ArrayList<Interval>();
		}
		ArrayList<Entry> entries = new ArrayList<Entry>();
		for (int i = 0; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			entries.add(new Entry(interval.start, true));
			entries.add(new Entry(interval.end, false));
		}
		Collections.sort(entries, new EntryComparator());

		ArrayList<Interval> solutions = new ArrayList<Interval>();
		int count = 0, s = -1, e = -1;
		int i = 0;
		while (true) {
			
			while (true) {
				if (entries.get(i).start) {
					if (s == -1) {
						s = entries.get(i).point;
					}
					++count;
				}else{
					--count;
				}
				if (i+1<entries.size() && entries.get(i+1).point == entries.get(i).point) {
					++i;
					continue;
				}else{
					break;
				}
			}
			if (count == 0) {
				e = entries.get(i).point;
				solutions.add(new Interval(s, e));
				s = -1;
			}
			
			++i;
			if (i == entries.size()) {
				break;
			}
		}
		return solutions;
	}
}
