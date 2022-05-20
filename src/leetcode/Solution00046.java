package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode.cn/problems/permutations/
 *
 * @author qiangfei
 * @date 2022/5/20 10:11
 */
public class Solution00046 {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *   
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *   
     * 示例 2：
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     *   
     * 示例 3：
     * 输入：nums = [1]
     * 输出：[[1]]
     *  
     * 提示：
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0, nums.length - 1);
    }

    private List<List<Integer>> permute(int[] nums, int start, int end) {
        List<List<Integer>> result = new ArrayList<>();
        if (start >= end) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[end]);
            result.add(list);
            return result;
        }
        List<List<Integer>> permute = permute(nums, start + 1, end);
        int num = nums[start];
        for (List<Integer> list : permute) {
            list.add(num);
            result.add(list);
        }
        for (int i = start + 1; i <= end; ++i) {
            swap(nums, start, i);
            num = nums[start];
            permute = permute(nums, start + 1, end);
            for (List<Integer> list : permute) {
                list.add(num);
                result.add(list);
            }
            swap(nums, start, i);
        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
