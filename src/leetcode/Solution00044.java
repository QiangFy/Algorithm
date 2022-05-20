package leetcode;

/**
 * 44. 通配符匹配
 * https://leetcode.cn/problems/wildcard-matching/
 *
 * @author qiangfei
 * @date 2022/5/19 22:57
 */
public class Solution00044 {
    /**
     * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     * 两个字符串完全匹配才算匹配成功。
     *   
     * 说明:
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
     *   
     * 示例 1:
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     *   
     * 示例 2:
     * 输入:
     * s = "aa"
     * p = "*"
     * 输出: true
     * 解释: '*' 可以匹配任意字符串。
     *   
     * 示例 3:
     * 输入:
     * s = "cb"
     * p = "?a"
     * 输出: false
     * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
     *   
     * 示例 4:
     * 输入:
     * s = "adceb"
     * p = "*a*b"
     * 输出: true
     * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
     *   
     * 示例 5:
     * 输入:
     * s = "acdcb"
     * p = "a*c?b"
     * 输出: false
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if ("*".equals(p)) {
            return true;
        }
        boolean[][] result = new boolean[s.length() + 1][p.length() + 1];
        result[0][0] = true;
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        for (int j = 0; j < cp.length; ++j) {
            if (cp[j] == '*') {
                result[0][j + 1] = true;
            } else {
                break;
            }
        }
        for (int i = 0; i < cs.length; ++i) {
            char s1 = cs[i];
            for (int j = 0; j < cp.length; ++j) {
                char p1 = cp[j];
                if (p1 == '?' || p1 == s1) {
                    result[i + 1][j + 1] = result[i][j];
                } else if (p1 == '*') {
                    result[i + 1][j + 1] = result[i][j] || result[i + 1][j] || result[i][j + 1];
                }
            }
        }
        return result[cs.length][cp.length];
    }
}
