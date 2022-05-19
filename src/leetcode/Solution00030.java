package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串
 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
 *
 * @author qiangfei
 * @date 2022/5/16 15:31
 */
public class Solution00030 {
    /**
     * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
     *   
     * 示例 1：
     * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：
     * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
     * 输出的顺序不重要, [9,0] 也是有效答案。
     *   
     * 示例 2：
     * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
     * 输出：[]
     *   
     * 示例 3：
     * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
     * 输出：[6,9,12]
     *  
     * 提示：
     * 1 <= s.length <= 10^4
     * s 由小写英文字母组成
     * 1 <= words.length <= 5000
     * 1 <= words[i].length <= 30
     * words[i] 由小写英文字母组成
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        int wl = words[0].length();
        int wsl = wl * words.length;
        List<Integer> result = new ArrayList<>();
        if (s.length() < wsl) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wl; ++i) {
            int left = i;
            int right = i;
//            构造一个滑动窗口
            for (int j = i; j <= s.length() - wsl; j += wl) {
//                把上一次滑动窗口最左边的word加回来
                if (left < j) {
                    String word = s.substring(left, left + wl);
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    }
                    left = j;
                }
//                right在字符串一直不匹配的时候落后j，进行修正
                if (right < j) {
                    right = j;
                }
//                right在滑动窗口中移动到最右端
                while (right < j + wsl) {
                    String word = s.substring(right, right + wl);
                    Integer count = map.get(word);
                    if (count != null && count > 0) {
                        map.put(word, count - 1);
                        right += wl;
                    } else {
                        break;
                    }
                }
//                滑动窗口完全匹配
                if (right == j + wsl) {
                    result.add(j);
                }
            }
//            还原map
            while (right > left) {
                String word = s.substring(right - wl, right);
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                }
                right -= wl;
            }
        }
        return result;
    }
}
