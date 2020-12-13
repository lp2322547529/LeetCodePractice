package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:linpeng
 * @date:20201203
 * @version:v1.0
 */
public class KSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int num = 4;
        if(nums.length < num) {
            throw new IllegalArgumentException("数组元素不足，无效输入！");
        }

        Arrays.sort(nums);
        return listKSum(target, num, nums, 0);
    }

    public static List<List<Integer>> KSum(int k, int[] nums, int target) {
        if(nums.length < k) {
            throw new IllegalArgumentException("数组元素不足，无效输入！");
        }

        Arrays.sort(nums);
        return listKSum(target, k, nums, 0);
    }

    public static List<List<Integer>> listKSum(int target, int num, int[] nums, int start) {
        List<List<Integer>> result = new ArrayList<>();

        if(num == 2) {
            int sum = 0;
            int low = start;
            int high = nums.length - 1;
            while(low < high) {
                sum = nums[low] + nums[high];
                if(sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[high]);
                    list.add(nums[low]);
                    result.add(list);

                    // 两数之和时需要避免数字重复，因为数字有一个不变，另一个也必定不变，重复值
                    low++;
                    high--;
                    while(low < high && nums[low-1] == nums[low]) {
                        low++;
                    }
                    while(low < high && nums[high+1] == nums[high]) {
                        high--;
                    }
                } else if(sum > target){
                    // 值大右指针左移
                    high--;
                    while(low < high && nums[high+1] == nums[high]) {
                        high--;
                    }
                } else if(sum < target){
                    // 值下左指针右移
                    low++;
                    while(low < high && nums[low-1] == nums[low]) {
                        low++;
                    }
                }
            }
        } else {
            // 对于大于2的情况，需要遍历数组，并且对于每个值递归获得所有差值的组合
            for(int i = start; i < nums.length - num + 1; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                int current = nums[i];
                int difference = target - current;
                List<List<Integer>> subResult = listKSum(difference, num - 1, nums, i + 1);

                for(List<Integer> list : subResult) {
                    list.add(current);
                }

                result.addAll(subResult);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(KSum(4, nums, 0));
    }
}
