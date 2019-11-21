package stack;

/**
 * 42. 接雨水 hard
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * @author ilovejava1314
 * @date 2019/11/20 11:03
 */
public class TrappingRainWater {
    //暴力法 直接按问题描述进行。对于数组中的每个元素，
    // 找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

}
