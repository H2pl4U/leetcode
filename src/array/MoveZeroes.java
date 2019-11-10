package array;

/**
 * 283. 移动零  easy
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 1.必须在原数组上操作，不能拷贝额外的数组。
 * 2.尽量减少操作次数。
 * @author ilovejava1314
 * @date 2019/11/10 15:56
 */
public class MoveZeroes {
    /**
     * 双指针最优解
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0;i < nums.length;i++) {
            if(nums[i] != 0) {
                nums[j] = nums[i];
                if(i!=j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
