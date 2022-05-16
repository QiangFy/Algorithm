package leetcode;

import java.util.Stack;

/**
 * 20. 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/
 *
 * @author qiangfei
 * @date 2022/5/13 14:56
 */
public class Solution00020 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *  
     * 示例 1：
     * 输入：s = "()"
     * 输出：true
     *  
     * 示例 2：
     * 输入：s = "()[]{}"
     * 输出：true
     *  
     * 示例 3：
     * 输入：s = "(]"
     * 输出：false
     *  
     * 示例 4：
     * 输入：s = "([)]"
     * 输出：false
     *  
     * 示例 5：
     * 输入：s = "{[]}"
     * 输出：true
     *  
     * 提示：
     * 1 <= s.length <= 10^o4
     * s 仅由括号 '()[]{}' 组成
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character last = stack.pop();
                if (last == '(' && c != ')') {
                    return false;
                } else if (last == '[' && c != ']') {
                    return false;
                } else if (last == '{' && c != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
