package ArrayProblems;

import java.util.Arrays;

/**
 * @author:linpeng
 * @date:20201117
 * @version:v1.0
 */
public class ThreeSumClosest {

    /**
     *
     * @param nums
     * @param target
     * @return the sum of three integers in nums such that the sum is closest to target
     *
     * Example
     * Input: nums = [-1,2,1,-4], target = 1
     * Output: 2
     * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     *
     * Runtime: 4 ms Your runtime beats 85.04 % of java submissions.
     * Memory Usage: 39 MB Your memory usage beats 31.42 % of java submissions.
     */
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int length = nums.length;

        // 和threeSum一类问题，排序后双指针 O(n^2)
        Arrays.sort(nums);
        for(int i = 0; i < length && diff != 0; i++) {
            int leftpos = i + 1;
            int rightpos = length - 1;
            while(leftpos < rightpos) {
                int sum = nums[i] + nums[leftpos] + nums[rightpos];
                if(Math.abs(sum - target) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if(sum > target) {
                    rightpos --;
                } else {
                    leftpos ++;
                }
            }
        }
        return target - diff;
    }
}
