package Lintcode.Intensive.L2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class Entry {
	public int point;
	public boolean start;

	public Entry(int point, boolean start) {
		this.point = point;
		this.start = start;
	}
}

class ListComparator implements Comparator<Entry> {

	@Override
	public int compare(Entry o1, Entry o2) {
		// TODO Auto-generated method stub
		return o1.point - o2.point;
	}

}

public class CountOfAirplanes {
	/**
	 * @param intervals:
	 *            An interval array
	 * @return: Count of airplanes are in the sky.
	 */
	public int countOfAirplanes(List<Interval> airplanes) {
		if (airplanes == null || airplanes.size() == 0) {
			return 0;
		}

		ArrayList<Entry> list = new ArrayList<>();

		for (int i = 0; i < airplanes.size(); i++) {
			list.add(new Entry(airplanes.get(i).start, true));
			list.add(new Entry(airplanes.get(i).end, false));
		}
		Collections.sort(list, new ListComparator());

		int cnt = 0, max_value = Integer.MIN_VALUE;

		int i = 0;
		while (true) {
			
			while (true) {
				if (list.get(i).start) {
					cnt++;
				} else {
					cnt--;
				}
				if (i + 1 < list.size() && list.get(i + 1).point == list.get(i).point) {
					++i;
					continue;
				}else{
					break;
				}
			}
			if (cnt > max_value) {
				max_value = cnt;
			}
			i++;
			if (i == list.size()) {
				break;
			}
		}

		return max_value;
	}
}
