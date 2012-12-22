/**
 * Sanqiang Zhao Www.131X.Com Dec 18, 2012
 */
package LeetCode.OnlineJudge;

public class Q22_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int s = 0, length = height.length, e = length - 1;
        int MaxArea = Integer.MIN_VALUE;
        while (s < e) {
            int Height = Math.min(height[s], height[e]);
            int Area = Height * (e - s + 1);
            MaxArea = Area > MaxArea ? Area : MaxArea;
            if (height[s] > height[e]) {
                while (height[e] >= height[--e]) {
                }
            } else {
                while (height[s] >= height[++s]) {
                }
            }
        }
        return MaxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 2, 4, 3};
        int MaxArea = new Q22_ContainerWithMostWater().maxArea(height);
        System.out.println(MaxArea);
    }
}
