package leetcode;

/**
 * 14. 最长公共前缀
 * https://leetcode.cn/problems/longest-common-prefix/
 *
 * @author qiangfei
 * @date 2022/5/12 16:28
 */
public class Solution00014 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *  
     * 示例 1：
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     *  
     * 示例 2：
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     *  
     * 提示：
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        char[] standard = strs[0].toCharArray();
        int cur = 0;
        int end = standard.length;
        char[] chars;
        for (int i = 1; i < strs.length; ++i) {
            chars = strs[i].toCharArray();
            int length = Math.min(end, chars.length);
            while (cur < length) {
                if (chars[cur] != standard[cur]) {
                    break;
                }
                cur++;
            }
            if (cur < end) {
                end = cur;
            }
            cur = 0;
        }
        return end > 0 ? String.valueOf(standard, 0, end) : "";
    }
}
