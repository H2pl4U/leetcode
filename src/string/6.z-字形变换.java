import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
    }

    /**
     * flag控制赋值的下标
     * StringBuidler的List长度为numRows
     * 遍历字符串s,通过下标轮询赋值给List对应的下标中的StringBuilder
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int index = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(index).append(c);
            if (index == 0 || index == (numRows - 1)) {
                flag = - flag;
            }
            index += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : rows) {
            res.append(sb);
        }
        return res.toString();
    }
}
// @lc code=end

