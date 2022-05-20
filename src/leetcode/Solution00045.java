package leetcode;

/**
 * 45. 跳跃游戏 II
 * https://leetcode.cn/problems/jump-game-ii/
 *
 * @author qiangfei
 * @date 2022/5/19 23:32
 */
public class Solution00045 {
    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     *   
     * 示例 1:
     * 输入: nums = [2,3,1,1,4]
     *   
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     *   
     * 示例 2:
     * 输入: nums = [2,3,0,1,4]
     * 输出: 2
     *   
     * 提示:
     * 1 <= nums.length <= 10^4
     * 0 <= nums[i] <= 1000
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        return jump(nums, 0, nums.length - 1);
    }

    private int jump(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int step = nums[start];
        if (start + step >= end) {
            return 1;
        }
        int trans = start;
        for (int i = start + 1; i <= step + start; ++i) {
            if (nums[i] > 0 && nums[i] + i > nums[trans] + trans) {
                trans = i;
            }
        }
        return jump(nums, trans, end) + 1;
    }
}
