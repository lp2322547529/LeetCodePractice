# Problem 18 - 4Sum

From: Leetcode

Difficulty: Medium



## 问题描述

Given an array `nums` of *n* integers and an integer `target`, are there elements *a*, *b*, *c*, and *d* in `nums` such that *a* + *b* + *c* + *d* = `target`? Find all unique quadruplets in the array which gives the sum of `target`.

**Notice** that the solution set must not contain duplicate quadruplets.



## 示例

```
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
```

```
Input: nums = [], target = 0
Output: []
```

**Constraints:**

- `0 <= nums.length <= 200`
- `-109 <= nums[i] <= 109`
- `-109 <= target <= 109`



## 思路

 	**从前有道题，题目叫2Sum；题后有道拓展，题目叫3Sum；拓展说好事要成双，所以遇见了4Sum。SUM家族人丁兴旺，是否搞个KSum聚会，把家族所有兄弟姐妹叫过来磨练程序员哥哥的心智。Just do it！**

​	（1）将数组排序，可使用双指针从头尾依次靠近求和降低时间复杂度

​	（2）需要递归依次降N的值，终点是2Sum。其中recursion函数需要的参数：

​			  target - sum目标值	num - K求和的数字个数	

​			  array - 保存数字的数组	start - 循环起点，从前向后缩小范围，防止多次使用数字，可起到去重作用

​	（3）如何去重：递归的机制。也可使用HashSet的特性由集合去重



## 代码

```java
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
                int current = nums[i];·
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
·
```



## 结果

Runtime: 22 ms, faster than 21.16% of Java online submissions for 4Sum.

Memory Usage: 40 MB, less than 19.99% of Java online submissions for 4Sum.