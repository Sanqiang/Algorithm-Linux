/**
 * Sanqiang Zhao Www.131X.Com Dec 22, 2012
 */
package LeetCode.OnlineJudge;

import java.util.ArrayList;
import java.util.Iterator;

public class Q51_MergeIntervals {
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> solution = new ArrayList<>();
        int i, length = intervals.size();
        Interval pre = intervals.get(0);
        for (i = 1; i < length; ++i) {
            Interval cur = intervals.get(i);
            if (cur.start > pre.end) {
                solution.add(pre);
                pre = cur;
            } else {
                pre.start = Math.min(cur.start, pre.start);
                pre.end = Math.max(cur.end, pre.end);
            }
        }
        solution.add(pre);
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
    
    public static void main(String[] args) {
        Q51_MergeIntervals.Interval i1 = new Q51_MergeIntervals().new Interval(1, 3);
        Q51_MergeIntervals.Interval i2 = new Q51_MergeIntervals().new Interval(2, 6);
        Q51_MergeIntervals.Interval i3 = new Q51_MergeIntervals().new Interval(8, 10);
        Q51_MergeIntervals.Interval i4 = new Q51_MergeIntervals().new Interval(15, 18);
        ArrayList<Q51_MergeIntervals.Interval> old = new ArrayList<>();
        old.add(i1);
        old.add(i2);
        old.add(i3);
        old.add(i4);
        ArrayList<Q51_MergeIntervals.Interval> solution = new Q51_MergeIntervals().mergeMy(old);
        for (Iterator<Interval> it = solution.iterator(); it.hasNext();) {
            Q51_MergeIntervals.Interval interval = it.next();
            System.out.println("[" + interval.start + "," + interval.end + "]");
        }
    }

    //my way
    public ArrayList<Interval> mergeMy(ArrayList<Interval> intervals) {
        ArrayList<Interval> solution = new ArrayList<>();
        int i = 1, len = intervals.size();
        for (; i < len; i++) {
            if (intervals.get(i).start <= intervals.get(i - 1).end) {
                Interval temp = new Interval();
                temp.start = Math.min(intervals.get(i).start, intervals.get(i - 1).start);
                temp.end = Math.max(intervals.get(i).end, intervals.get(i - 1).end);
                while (i++ < len) {
                    if (intervals.get(i).start <= intervals.get(i - 1).end) {
                        temp.end = Math.max(intervals.get(i).end, intervals.get(i - 1).end);
                    } else {
                        break;
                    }
                }
                solution.add(temp);
            } else {
                solution.add(intervals.get(i - 1));
                if (i == len - 1) {
                    solution.add(intervals.get(i));
                }
            }
        }
        return solution;
    }
}
