package stack;

import java.util.Stack;

/**
 * 20. 有效的括号  easy
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true

 * @author ilovejava1314
 * @date 2019/11/11 14:46
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s = "(([]{}))";
        System.out.println(isValid(s));
    }
    /**
     * 利用栈匹配算法
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.empty();
    }

}
