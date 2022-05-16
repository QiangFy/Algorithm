package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 *
 * @author qiangfei
 * @date 2022/5/13 14:04
 */
public class Solution00017 {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *  
     * 示例 1：
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     *  
     * 示例 2：
     * 输入：digits = ""
     * 输出：[]
     *  
     * 示例 3：
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     *  
     * 提示：
     * 0 <= digits.length <= 4
     * digits[i] 是范围 ['2', '9'] 的一个数字。
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        String[][] nums = new String[10][];
        nums[2] = new String[]{"a", "b", "c"};
        nums[3] = new String[]{"d", "e", "f"};
        nums[4] = new String[]{"g", "h", "i"};
        nums[5] = new String[]{"j", "k", "l"};
        nums[6] = new String[]{"m", "n", "o"};
        nums[7] = new String[]{"p", "q", "r", "s"};
        nums[8] = new String[]{"t", "u", "v"};
        nums[9] = new String[]{"w", "x", "y", "z"};
        char[] chars = digits.toCharArray();
        result.add("");
        List<String> temp;
        for (int i = 0; i < chars.length; ++i) {
            temp = new ArrayList<>();
            for (String s : nums[chars[i] - '0']) {
                for (String r : result) {
                    temp.add(r + s);
                }
            }
            result = temp;
        }
        return result;
    }
}
