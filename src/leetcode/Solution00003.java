package leetcode;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 *
 * @author qiangfei
 * @date 2022/5/11 15:59
 */
public class Solution00003 {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * <p>
     * 示例 2:
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * <p>
     * 示例 3:
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 提示：
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] appears = new int[128];
        int start = 0;
        int result = 0;
        for (int i = 0; i < chars.length; ++i) {
            int last = appears[chars[i]];
            if (last > start) {
                if (i - start > result) {
                    result = i - start;
                }
                start = last;
            }
            appears[chars[i]] = i + 1;
        }
        if (chars.length - start > result) {
            result = chars.length - start;
        }
        return result;
    }
}
