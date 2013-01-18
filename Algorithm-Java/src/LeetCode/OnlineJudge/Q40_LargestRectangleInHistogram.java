/**
 * Sanqiang Zhao Www.131X.Com Dec 20, 2012
 */
package LeetCode.OnlineJudge;

import Util.TestUtil;
import java.util.Stack;

public class Q40_LargestRectangleInHistogram {

    //wrong
    public int largestRectangleAreaEx(int[] height) {
        int length = height.length, MaxArea = Integer.MIN_VALUE, s = 0, e = length - 1;
        while (s < e) {
            int cur = Math.min(height[s], height[e]) * (e - s + 1);
            MaxArea = Math.max(cur, MaxArea);
            if (height[s] >= height[e]) {
                while (height[e] >= height[--e]) {
                }
            } else {
                while (height[s] >= height[++s]) {
                }
            }
        }
        return MaxArea;
    }

    public int largestRectangleArea(int[] height) {
        int length = height.length, MaxArea = Integer.MIN_VALUE, ind = 0;
        Stack<Integer> height_stack = new Stack<>();
        Stack<Integer> index_stack = new Stack<>();
        height_stack.push(height[0]);
        index_stack.push(0);
        int i = 1;
        for (; i < length; ++i) {
            if (height[i] > height_stack.peek()) {
                height_stack.push(height[i]);
                index_stack.push(i);
            } else if (height[i] == height_stack.peek()) {
                continue;
            } else {
                do {
                    int h = height_stack.pop();
                    ind = index_stack.pop();
                    int area = h * (i - ind);
                    MaxArea = Math.max(area, MaxArea);
                } while (!height_stack.isEmpty() && height[i] < height_stack.peek());
                height_stack.push(height[i]);
                index_stack.push(ind);
            }
        }
        while (!height_stack.isEmpty()) {
            int h = height_stack.pop();
            ind = index_stack.pop();
            int area = h * (length - ind);
            MaxArea = Math.max(area, MaxArea);
        }
        return MaxArea;
    }

    public static void main(String[] args) {
        int[] height = {2, 1, 5, 6, 2, 3};
        int area = new Q40_LargestRectangleInHistogram().largestRectangleAreaMy(height);
        System.out.println(area);
        int area2 = new Q40_LargestRectangleInHistogram().largestRectangleAreaEx(height);
        System.out.println(area2);

        int[] height_test = {2, 5, 4, 1};//TestUtil.generateArray(9, 9, false);
        long l1 = System.currentTimeMillis();
        int area_t1 = new Q40_LargestRectangleInHistogram().largestRectangleArea(height_test);
        long l2 = System.currentTimeMillis();
        int area_t2 = new Q40_LargestRectangleInHistogram().largestRectangleAreaEx(height_test);
        long l3 = System.currentTimeMillis();
        long span1 = l2 - l1, span2 = l3 - l2;
        System.out.println(area_t1 + " Cost " + span1);
        System.out.println(area_t2 + " Cost " + span2);
    }

    //my way correct
    public int largestRectangleAreaMy(int[] height) {
        Stack<Wrapper> stack = new Stack<>();
        int len = height.length, i = 0;
        int max = 0;
        while (i < len) {
            if (stack.isEmpty() || height[i] > stack.peek()._height) {
                stack.push(new Wrapper(height[i], i));
            } else if (stack.peek()._height > height[i]) {
                int prev = 0;
                while (!stack.isEmpty() && stack.peek()._height > height[i]) {
                    Wrapper wr = stack.pop();
                    prev = wr._index;
                    max = Math.max(max, (i - prev) * wr._height);
                }
                stack.push(new Wrapper(height[i], prev));
            }
            ++i;
        }
        while (!stack.isEmpty()) {
            Wrapper wr = stack.pop();
            max = Math.max(max, (i - wr._index) * wr._height);
        }
        return max;
    }

    class Wrapper {

        int _height;
        int _index;

        public Wrapper(int height, int index) {
            this._height = height;
            this._index = index;
        }
    }
}
