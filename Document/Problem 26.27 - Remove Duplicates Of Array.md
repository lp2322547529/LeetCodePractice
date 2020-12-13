# Problem 26.27 - Remove Duplicates Of Array

From: Leetcode

Difficulty: Easy



## 问题描述

Given a sorted array *nums*, remove the duplicates [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) such that each element appears only *once* and returns the new length.

Do not allocate extra space for another array, you must do this by **modifying the input array [in-place](https://en.wikipedia.org/wiki/In-place_algorithm)** with O(1) extra memory.



Given an array *nums* and a value *val*, remove all instances of that value [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) and return the new length.

Do not allocate extra space for another array, you must do this by **modifying the input array [in-place](https://en.wikipedia.org/wiki/In-place_algorithm)** with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.



**Clarification:**

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by **reference**, which means a modification to the input array will be known to the caller as well.

Internally you can think of this:

```
// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
```



## 示例

```
Input: nums = [1,1,2]
Output: 2, nums = [1,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the returned length.
```

```
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]
Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter what values are set beyond the returned length.
```



```
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 2.
It doesn't matter what you leave beyond the returned length. For example if you return 2 with nums = [2,2,3,3] or nums = [2,3,0,0], your answer will be accepted.
```



## 思路

​	有序数组去重，但由于你不知道实际上具体有多少个不重复的数字，因此无法初始化数组大小，因此需要先使用其他有序的数据结构ArrayList,Queue等保存，之后转换为数组返回。使用遍历current保存当前结果集中最后一个数字（最大的），如果比对的一致则略过。（实际上去重还可以使用set的去重特性）。

PS：这题的返回方式就挺离谱的，虽然简单但是略坑，难怪这么多人踩。就用一个数保存当前去重后的数组结尾下标，一定小于等于数组的length，一面使用变量对比，不一致就放在pos位置上。



​	Remove Element的思路基本一致，比较的是num[i] 和 val是否一致。

## 代码

```java
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }

        int current = nums[0];
        int pos = 0;
        int temp;
        for(int i = 1; i < nums.length; i++) {
            temp = nums[i];
            if(temp == current) {
                continue;
            }

            nums[pos + 1] = temp;
            current = temp;
            pos++;
        }

        return pos + 1;
    }

	public int removeElement(int[] nums, int val) {
        int pos = -1;
        int current;
        for(int i = 0; i < nums.length; i++) {
            current = nums[i];
            if(current == val) {
                continue;
            }

            nums[++pos] = current;
        }

        return pos + 1;
    }
```



## 结果

Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array.

Memory Usage: 41.2 MB, less than 12.51% of Java online submissions for Remove Duplicates from Sorted Array.



Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.

Memory Usage: 37.5 MB, less than 63.04% of Java online submissions for Remove Element.