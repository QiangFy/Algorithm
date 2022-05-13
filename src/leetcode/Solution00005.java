package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 5. 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/
 *
 * @author qiangfei
 * @date 2022/5/11 17:49
 */
public class Solution00005 {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *  
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *  
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     *  
     * 提示：
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母组成
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        char[] proCs = preProcess(s);
        int length = proCs.length;
        int[] proRs = new int[length];
        int center = 0;
        int r = 0;
        for (int i = 1; i < length - 1; i++) {
            int iMirror = 2 * center - i;
            if (r > i) {
                proRs[i] = Math.min(r - i, proRs[iMirror]);
            } else {
                proRs[i] = 0;
            }

            while (proCs[i + 1 + proRs[i]] == proCs[i - 1 - proRs[i]]) {
                proRs[i]++;
            }

            if (i + proRs[i] > r) {
                center = i;
                r = i + proRs[i];
            }
        }

        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < length - 1; i++) {
            if (proRs[i] > maxLen) {
                maxLen = proRs[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    private char[] preProcess(String s) {
        if (s == null || s.length() == 0) {
            return new char[]{'^', '$'};
        }
        int length = s.length() * 2 + 3;
        char[] chars = s.toCharArray();
        char[] result = new char[length];
        result[0] = '^';
        result[length - 1] = '$';
        for (int i = 1; i < length - 1; ++i) {
            result[i] = (i & 1) == 0 ? chars[i - 1 >> 1] : '#';
        }
        return result;
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        Set<Integer> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int maxLength = 1;
        int end = 1;
        for (int i = 0; i < chars.length; ++i) {
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()) {
                Integer center = iterator.next();
                if (center < i || chars[center - i] != chars[i]) {
                    iterator.remove();
                    if (2 * i - center - 1 > maxLength) {
                        maxLength = 2 * i - center - 1;
                        end = i;
                    }
                }
            }
            set.add(2 * i);
            set.add(2 * i + 1);
        }
        for (Integer center : set) {
            if (2 * chars.length - center - 1 > maxLength) {
                maxLength = 2 * chars.length - center - 1;
                end = chars.length;
            }
        }
        return s.substring(end - maxLength, end);
    }
}
