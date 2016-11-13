package Lintcode.Intensive.L2;

import java.util.ArrayList;
import java.util.Collections;


public class Insert {
	/**
	 * Insert newInterval into intervals.
	 * 
	 * @param intervals:
	 *            Sorted interval list.
	 * @param newInterval:
	 *            A new interval.
	 * @return: A new sorted interval list.
	 */
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		ArrayList<Entry> entries = new ArrayList<Entry>();
		for (int i = 0; i < intervals.size(); i++) {
			entries.add(new Entry(intervals.get(i).start, true));
			entries.add(new Entry(intervals.get(i).end, false));
		}
		entries.add(new Entry(newInterval.start, true));
		entries.add(new Entry(newInterval.end, false));
		Collections.sort(entries, new EntryComparator());
		
		int i = 0, cnt = 0, start = -1, end =-1;
		while (true) {
			while (true) {
				if(entries.get(i).start){
					if (start == -1) {
						start = entries.get(i).point;
					}
					++cnt;
				}else{
					--cnt;
				}
				if (i+1<entries.size() && entries.get(i).point == entries.get(i+1).point) {
					++i;
					continue;
				}else{
					break;
				}
			}
			if (cnt == 0) {
				end = entries.get(i).point;
				result.add(new Interval(start, end));
				start = -1;
			}
			++i;
			if (i == entries.size()) {
				break;
			}
		}
		
		return result;
	}
}
