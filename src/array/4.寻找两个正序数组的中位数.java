/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 5};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 暴力法 O(m+n) 不符合题意
     * 合并数组,根据奇数偶数返回中位数,没使用有序性条件
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                arr[i + j] = nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                arr[i + j] = nums2[j];
                j++;
            } else {
                arr[i + j] = nums1[i];
                i++;
                arr[i + j] = nums2[j];
                j++;
            }
        }
        while (i < nums1.length) {
            arr[i + j] = nums1[i];
            i++;
        }
        while (j < nums2.length) {
            arr[i + j] = nums2[j];
            j++;
        }
        if (arr.length % 2 == 1) {
            return (double)arr[arr.length / 2];
        } else {
            return (double)(arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2;
        }

    }
}
// @lc code=end

