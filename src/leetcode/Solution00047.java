package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 47. 全排列 II
 * https://leetcode.cn/problems/permutations-ii/
 *
 * @author qiangfei
 * @date 2022/5/20 10:55
 */
public class Solution00047 {
    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * <p>
     * 示例 1：
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * <p>
     * 示例 2：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * <p>
     * 提示：
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permuteUnique(nums, 0, nums.length - 1);
    }

    private List<List<Integer>> permuteUnique(int[] nums, int start, int end) {
        List<List<Integer>> result = new ArrayList<>();
        if (start >= end) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[end]);
            result.add(list);
            return result;
        }
        List<List<Integer>> permute = permuteUnique(nums, start + 1, end);
        int num = nums[start];
        for (List<Integer> list : permute) {
            list.add(num);
            result.add(list);
        }
        int existed = 0;
//        用BitMap记录已经交换过位置的数字
        existed = existed | 1 << (num + 10);
        for (int i = start + 1; i <= end; ++i) {
            if ((existed & (1 << (nums[i] + 10))) > 0) {
                continue;
            }
            swap(nums, start, i);
            num = nums[start];
            permute = permuteUnique(nums, start + 1, end);
            for (List<Integer> list : permute) {
                list.add(num);
                result.add(list);
            }
            existed = existed | 1 << (num + 10);
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
