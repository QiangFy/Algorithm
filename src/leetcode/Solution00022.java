package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode.cn/problems/generate-parentheses/
 *
 * @author qiangfei
 * @date 2022/5/13 15:10
 */
public class Solution00022 {
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *  
     * 示例 1：
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     *  
     * 示例 2：
     * 输入：n = 1
     * 输出：["()"]
     *  
     * 提示：
     * 1 <= n <= 8
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "", n, n);
        return result;
    }

    private void generateParenthesis(List<String> result, String cur, int l, int r) {
        if (l == 0 && r == 0) {
            result.add(cur);
            return;
        }
        if (l > 0) {
            generateParenthesis(result, cur + "(", l - 1, r);
        }
        if (r > l) {
            generateParenthesis(result, cur + ")", l, r - 1);
        }
    }
}
