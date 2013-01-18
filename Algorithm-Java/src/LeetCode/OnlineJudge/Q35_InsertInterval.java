/**
 * Sanqiang Zhao Www.131X.Com Dec 20, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;
import java.util.Iterator;

public class Q35_InsertInterval {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> solution = new ArrayList<>();
        int i = 0, length = intervals.size();
        for (; i < length; ++i) {
            Interval cur = intervals.get(i);
            if (newInterval.start > cur.end) {
                solution.add(cur);
            } else if (newInterval.end < cur.start) {
                solution.add(newInterval);
                while (i < length) {
                    solution.add(intervals.get(i++));
                }
            } else if (newInterval.end >= cur.start || newInterval.start <= cur.end) {
                newInterval.start = Math.min(newInterval.start, cur.start);
                newInterval.end = Math.max(newInterval.end, cur.end);
            }

        }
        if (solution.isEmpty()) {
            solution.add(newInterval);
        }
        return solution;
    }

    public class Interval {

        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> generateSample() {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(10, 12));
        return intervals;
    }

    public Interval generateInterval(int s, int e) {
        return new Interval(s, e);
    }

    public static void main(String[] args) {
        Q35_InsertInterval q35 = new Q35_InsertInterval();
        ArrayList<Interval> intervals = q35.generateSample();
        Interval newInterval = q35.generateInterval(2, 11);
        ArrayList<Interval> solutions = q35.insertMy(intervals, newInterval);
        for (Iterator<Interval> it = solutions.iterator(); it.hasNext();) {
            Q35_InsertInterval.Interval interval_item = it.next();
            System.out.println("[" + interval_item.start + "," + interval_item.end + "]");

        }
    }

    //my way
    public ArrayList<Interval> insertMy(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> solution = new ArrayList<>();
        int len = intervals.size();
        for (int i = 0; i < len; i++) {
            Interval cur = intervals.get(i);
            if (newInterval.start > cur.end || newInterval.end < cur.start) {
                solution.add(cur);
            } else if (newInterval.start <= cur.end) {
                Interval temp = new Interval();
                temp.start = Math.min(newInterval.start, cur.start);
                if (newInterval.end <= cur.end) {
                    temp.end = Math.max(cur.end, newInterval.end);
                } else {
                    while (++i < len) {
                        cur = intervals.get(i);
                        if (newInterval.end <= cur.end) {
                            temp.end = Math.max(cur.end, newInterval.end);
                            break;
                        }
                    }
                }
                solution.add(temp);
            }
        }
        return solution;
    }
}
