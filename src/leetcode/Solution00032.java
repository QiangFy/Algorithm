package leetcode;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * https://leetcode.cn/problems/longest-valid-parentheses/
 *
 * @author qiangfei
 * @date 2022/5/17 16:10
 */
public class Solution00032 {
    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     *   
     * 示例 1：
     * 输入：s = "(()"
     * 输出：2
     * 解释：最长有效括号子串是 "()"
     *   
     * 示例 2：
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     *   
     * 示例 3：
     * 输入：s = ""
     * 输出：0
     *  
     * 提示：
     * 0 <= s.length <= 3 * 10^4
     * s[i] 为 '(' 或 ')'
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int[] max = new int[chars.length];
        int result = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == '(') {
                stack.push(i);
                max[i] = 0;
            } else {
                if (!stack.isEmpty()) {
                    int last = stack.pop();
                    max[i] = i - last + 1 + (last > 0 ? max[last - 1] : 0);
                    if (result < max[i]) {
                        result = max[i];
                    }
                } else {
                    max[i] = 0;
                }
            }
        }
        return result;
    }
}
