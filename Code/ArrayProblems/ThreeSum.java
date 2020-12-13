package ArrayProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:linpeng
 * @date:
 * @version:v1.0
 */
public class ThreeSum {

    /**
     *
     * @param nums
     * @return
     *
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     *
     * Example
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     *
     * Mark
     * Runtime: 309 ms, faster than 22.27% of Java online submissions for 3Sum.
     * Memory Usage: 44.9 MB, less than 10.72% of Java online submissions for 3Sum.
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length <= 2) {
            return res;
        }

        HashMap<String, String> map = new HashMap();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int sum = 0 - nums[i];

            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    String key = nums[i] + "," + nums[left] + "," + nums[right];
                    if (!map.containsKey(key)) {
                        map.put(key, "");
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
