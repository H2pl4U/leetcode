package array;

/**
 * 189. 旋转数组 easy
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 *
 * 1尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 2要求使用空间复杂度为 O(1) 的 原地 算法。
 * @author ilovejava1314
 * @date 2019/11/10 16:56
 */
public class RotateArray {
    /**
     * 方法1
     * 双重循环，循环k次 O(k*N)
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length-1];
            for (int j = nums.length-2; j >= 0; j--) {
                nums[j+1] = nums[j];
            }
            nums[0] = temp;
        }
    }

    /**
     * 方法2
     * 使用新数组 将原数组中i放在第i+k的位置，再赋值给老数组
     * O(n)
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[(i+k)%len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = array[i];
        }
    }

    /**
     * 方法3
     * 反转法，先反转整体，再反转前k个，最后反转后k个
     * O(n) 最优解
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length);
        reverse(nums,0,k);
        reverse(nums,k + 1,nums.length);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
