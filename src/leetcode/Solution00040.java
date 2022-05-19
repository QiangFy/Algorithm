package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * https://leetcode.cn/problems/combination-sum-ii/
 *
 * @author qiangfei
 * @date 2022/5/19 18:34
 */
public class Solution00040 {
    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     * 注意：解集不能包含重复的组合。 
     *   
     * 示例 1:
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     *   
     * 示例 2:
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 输出:
     * [
     * [1,2,2],
     * [5]
     * ]
     *   
     * 提示:
     * 1 <= candidates.length <= 100
     * 1 <= candidates[i] <= 50
     * 1 <= target <= 30
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, 0, target);
    }

    private List<List<Integer>> combinationSum(int[] candidates, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < candidates.length; ++i) {
            int num = candidates[i];
            if (i > start && num == candidates[i - 1]) {
                continue;
            }
            if (num == target) {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                result.add(list);
            } else if (num < target) {
                List<List<Integer>> subs = combinationSum(candidates, i + 1, target - num);
                for (List<Integer> list : subs) {
                    list.add(num);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
