package array;

/**
 * 66. 加一 easy
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * @author ilovejava1314
 * @date 2019/11/10 17:36
 */
public class PlusOne {
    /**
     * 从后向前，让元素++，对10取余，若余数不为0则直接返回结果
     * 当所有元素对10取余都为0，说明各个位都是9，需要进位
     * 最优解
     *
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0 ; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0)
                return digits;
        }
        int[] array = new int[digits.length+1];
        array[0] = 1;
        return array;
    }
}
