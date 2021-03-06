package array;

/**
 * 26. 删除排序数组中的重复项 easy
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * @author ilovejava1314
 * @date 2019/11/10 16:28
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * 快慢指针，只要nums[i]==nums[j]，就增加 j 以跳过重复项。
     * 最优解
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1;j < nums.length;j++) {
            if(nums[i] != nums[j]){
                i++;
                //更新nums[i]的值
                nums[i] = nums[j];
            }
        }
        return ++i;
    }

}
