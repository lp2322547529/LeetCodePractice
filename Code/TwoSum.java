import java.util.HashMap;

/**
 * @author:linpeng
 * @date:20201027
 * @version:v1.0
 */
public class TwoSum {
    /**
     *
     * @param nums
     * @param target
     * @return indices of the two numbers such that they add up to target
     * Each input would have exactly one solution, and you may not use the same element twice
     *
     * Example：
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
     *
     * Mark:
     * Runtime: 2 ms, faster than 67.94% of Java online submissions for Two Sum.
     * Memory Usage: 39.6 MB, less than 8.03% of Java online submissions for Two Sum.
     */
    public static int[] twoSum(int[] nums, int target) throws Exception{
        if(nums.length <= 1) {
            throw new IllegalArgumentException("数组元素个数小于2，无效输入！");
        }

        int current, last;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            current = nums[i];
            last = target - current;
            if(map.containsKey(last)) {
                return new int[] {map.get(last), i};
            } else {
                map.put(current, i);
            }
        }

        throw new IllegalArgumentException("在数组nums中无法找到和为" + target + "的两个数！");
    }

    public static void main(String[] args) {
        try {
            int[] nums = {2,7,11,15};
            int[] result = twoSum(nums, 27);
            for (int i: result) {
                System.out.println(i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
