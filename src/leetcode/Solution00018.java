package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * https://leetcode.cn/problems/4sum/
 *
 * @author qiangfei
 * @date 2022/5/13 14:23
 */
public class Solution00018 {
    /**
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
     * 0 <= a, b, c, d < n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * 你可以按 任意顺序 返回答案 。
     *  
     * 示例 1：
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     *  
     * 示例 2：
     * 输入：nums = [2,2,2,2,2], target = 8
     * 输出：[[2,2,2,2]]
     *  
     * 提示：
     * 1 <= nums.length <= 200
     * -10^9 <= nums[i] <= 10^9
     * -10^9 <= target <= 10^9
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; ++i) {
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; ++j) {
                int tSum = nums[i] + nums[j];
                if ((long) tSum + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) tSum + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int l = j + 1;
                int r = length - 1;
                while (l < r) {
                    int sum = tSum + nums[l] + nums[r];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            ++l;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            --r;
                        }
                        ++l;
                        --r;
                    } else if (sum < target) {
                        ++l;
                    } else {
                        --r;
                    }
                }
                while (j < length - 2 && nums[j] == nums[j + 1]) {
                    ++j;
                }
            }
            while (i < length - 3 && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
        return result;
    }
}
