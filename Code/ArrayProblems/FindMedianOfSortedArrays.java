package ArrayProblems;

/**
 * @author:linpeng
 * @date:20201102
 * @version:v1.0
 */
public class FindMedianOfSortedArrays {

    /**
     *
     * @param nums1
     * @param nums2
     * @return  return the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     *
     *Example
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 2.50000
     * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
     *
     * Mark
     * Runtime: 2 ms, faster than 99.70% of Java online submissions for Median of Two Sorted Arrays.
     * Memory Usage: 40.1 MB, less than 8.87% of Java online submissions for Median of Two Sorted Arrays.
     *
     * reference：https://www.cnblogs.com/grandyang/p/4465932.html
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // 正常思路：双指针遍历两个数组，找到中位数位置的值/均值  时间复杂度：O(m+n)
        // 找到第(m+n+1)/2和(m+n+2)/2顺序的数，求均值即可
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2;
    }

    /**
     *
     * @param nums1
     * @param i num1起点
     * @param nums2
     * @param j num2起点
     * @param k
     * @return 第k大小的元素
     */
    private static double findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        // 8 9 -> 第9大小的数即 12
        int[] nums1 = {1,5,6,9,12,32,74,99};
        int[] nums2 = {2,4,7,9,21,66,81,120,131};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}
