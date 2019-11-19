package queue;

import java.util.ArrayDeque;

/**
 * 239. 滑动窗口最大值 hard
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 *
 * @author ilovejava1314
 * @date 2019/11/19 14:02
 */
public class SlidingWindowMaximum {
    //暴力法，两次遍历，外循环从0到n-k，内循环找出i到i+k之间的最大值，并存入结果数组中
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0;i < nums.length - k + 1;i++) {
            int max = nums[i];
            for (int j = i+1; j < i + k; j++) {
                if(max < nums[j]) {
                    max = nums[j];
                }
            }
            res[i] = max;
        }
        return res;
    }

    //双端队列
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;

    public void clean_deque(int i, int k) {
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
            deq.removeLast();
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[max_idx];
        for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }
}
