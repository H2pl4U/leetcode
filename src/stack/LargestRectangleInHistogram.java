package stack;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形 hard
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * @author ilovejava1314
 * @date 2019/11/17 22:55
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }

    //1.暴力解法(优化后)，遍历一次，找到每个元素的左右边界，进而得到面积，从中取得最大值
    public static int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int j = i, k = i;
            while(j - 1 >= 0 && heights[j - 1] >= heights[i])
                j--;
            while (k < heights.length - 1 && heights[k + 1] >= heights[i])
                k++;
            max = Math.max(max,(k - j + 1)*heights[i]);
        }
        return max;
    }

    //2.栈方法，利用栈的特性，确认每个元素的边界，避免了重复查找边界
    public static int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                maxArea = Math.max(maxArea,heights[stack.peek()]*(i - stack.pop() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea,heights[stack.peek()]*(heights.length - stack.pop() - 1));
        }
        return maxArea;
    }
}
