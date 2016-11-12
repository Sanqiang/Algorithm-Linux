/**
 * Sanqiang Zhao Www.131X.Com Jan 5, 2013
 */
package CareerCup.SortAndSearch;

import java.util.ArrayList;

public class Q11_7_LongestSubsequence {

    public ArrayList<HtWt> find(ArrayList<HtWt> items) {
        int length = items.size();
        ArrayList<HtWt>[] solutions = new ArrayList[length];
        ArrayList<HtWt> best = null;
        for (ArrayList<HtWt> list : solutions) {
            best = setBest(list, best);
        }
        return best;
    }

    public void findDP(ArrayList<HtWt>[] solutions, ArrayList<HtWt> items, int index) {
        if (index == solutions.length) {
            return;
        }
        HtWt cur = items.get(index);
        ArrayList<HtWt> cur_best = null;
        for (int i = 0; i < index; i++) {
            ArrayList<HtWt> pre_best = solutions[i];
            cur_best = setBest(pre_best, cur_best);
        }
        ArrayList<HtWt> solution = new ArrayList<>();
        if (cur_best != null) {
            solution.addAll(cur_best);
        }
        solution.add(cur);
        solutions[index] = solution;
        findDP(solutions, items, index + 1);
    }

    private ArrayList<HtWt> setBest(ArrayList<HtWt> list1, ArrayList<HtWt> list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        if (list1.size() > list2.size()) {
            return list1;
        } else {
            return list2;
        }
    }

    public static void main(String[] args) {
    }

    class HtWt {

        public int height;
        public int weight;

        public HtWt() {
        }

        public HtWt(int h, int w) {
            this.height = h;
            this.weight = w;
        }

        public boolean canBeAfter(HtWt hw) {
            return this.height > hw.height && this.weight > hw.height;
        }

        public boolean canBeBefore(HtWt hw) {
            return this.height < hw.height && this.weight < hw.height;
        }
    }
}
