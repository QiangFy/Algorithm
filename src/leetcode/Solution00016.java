package leetcode;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * https://leetcode.cn/problems/3sum-closest/
 *
 * @author qiangfei
 * @date 2022/5/13 13:41
 */
public class Solution00016 {
    /**
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     * 返回这三个数的和。
     * 假定每组输入只存在恰好一个解。
     *  
     * 示例 1：
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     *  
     * 示例 2：
     * 输入：nums = [0,0,0], target = 1
     * 输出：0
     *  
     * 提示：
     * 3 <= nums.length <= 1000
     * -1000 <= nums[i] <= 1000
     * -10^4 <= target <= 10^4
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 10000;
        for (int i = 0; i < nums.length - 2; ++i) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (target == sum) {
                    return sum;
                } else if (Math.abs(target - result) > Math.abs(target - sum)) {
                    result = sum;
                }
                if (sum < target) {
                    while (l < r && nums[l] == nums[l + 1]) {
                        ++l;
                    }
                    ++l;
                } else {
                    while (l < r && nums[r] == nums[r - 1]) {
                        --r;
                    }
                    --r;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
        return result;
    }
}
