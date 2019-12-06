package hash;

import java.util.Arrays;

/**
 * 242. 有效的字母异位词  easy
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * @author ilovejava1314
 * @date 2019/12/5 15:04
 */
public class ValidAnagram {
    //暴力解法
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.toString(sc).equals(Arrays.toString(tc));
    }

    //hash解法
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] arr = new int[24];
        for (int i = 0; i < 24; i++) {
            arr[s.charAt(i) - 97]++;
            arr[t.charAt(i) - 97]--;
        }
        for (int i: arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
