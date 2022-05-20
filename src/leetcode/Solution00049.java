package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 * https://leetcode.cn/problems/group-anagrams/
 *
 * @author qiangfei
 * @date 2022/5/20 12:49
 */
public class Solution00049 {
    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     *   
     * 示例 1:
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *   
     * 示例 2:
     * 输入: strs = [""]
     * 输出: [[""]]
     *   
     * 示例 3:
     * 输入: strs = ["a"]
     * 输出: [["a"]]
     *  
     * 提示：
     *   
     * 1 <= strs.length <= 10^4
     * 0 <= strs[i].length <= 100
     * strs[i] 仅包含小写字母
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 1) {
            List<String> list = new ArrayList<>();
            list.add(strs[0]);
            result.add(list);
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            List<String> list = map.get(s);
            if (list == null) {
                list = new ArrayList<>();
                map.put(s, list);
                result.add(list);
            }
            list.add(str);
        }
        return result;
    }
}
