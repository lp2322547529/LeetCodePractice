package RealitySituation;

/**
 * @author:linpeng
 * @date:20201115
 * @version:v1.0
 */
public class ContainsMostWater {

    /**
     *
     * @param height
     * @return maxArea
     *
     * Given n non-negative integers where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
     * Find two lines, which, together with the x-axis forms a container,
     * such that the container contains the most water.
     *
     * Example
     * Input: height = [4,3,2,1,4]
     * Output: 16
     *
     * Mark
     * Runtime: 2 ms, faster than 94.83% of Java online submissions for Container With Most Water.
     * Memory Usage: 40.8 MB, less than 15.53% of Java online submissions for Container With Most Water.
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while(left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));

            if(height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
