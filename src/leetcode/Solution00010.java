package leetcode;

/**
 * 10. 正则表达式匹配
 * https://leetcode.cn/problems/regular-expression-matching/
 *
 * @author qiangfei
 * @date 2022/5/12 09:25
 */
public class Solution00010 {
    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *  
     * 示例 1：
     * 输入：s = "aa", p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     *  
     * 示例 2:
     * 输入：s = "aa", p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     *  
     * 示例 3：
     * 输入：s = "ab", p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     *  
     * 提示：
     * 1 <= s.length <= 20
     * 1 <= p.length <= 30
     * s 只包含从 a-z 的小写字母。
     * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 保证每次出现字符 * 时，前面都匹配到有效的字符
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        boolean[][] result = new boolean[cs.length + 1][cp.length + 1];
        result[0][0] = true;
//      需要先用p匹配一下空字符串
        for (int j = 2; j < cp.length; j += 2) {
            if (cp[j - 1] == '*') {
                result[0][j] = result[0][j - 2];
            }
        }
        for (int i = 1; i <= cs.length; ++i) {
            for (int j = 1; j <= cp.length; ++j) {
//                当前字符能够匹配上，则看上一个字符是否匹配上
                if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.') {
                    result[i][j] = result[i - 1][j - 1];
                } else if (cp[j - 1] == '*') {
//                    p的上一个字符能否匹配上s当前字符
                    if (cs[i - 1] == cp[j - 2] || cp[j - 2] == '.') {
//                        0个字符匹配上 || 1个字符匹配上 || 多个字符匹配上
                        result[i][j] = result[i][j - 2] || result[i][j - 1] || result[i - 1][j];
                    } else {
                        result[i][j] = result[i][j - 2];
                    }
                }
            }
        }
        return result[cs.length][cp.length];
    }
}
