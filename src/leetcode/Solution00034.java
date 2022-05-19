package leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author qiangfei
 * @date 2022/5/19 10:03
 */
public class Solution00034 {
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * 进阶：
     * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     *   
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     *   
     * 示例 2：
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     *   
     * 示例 3：
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *  
     * 提示：
     * 0 <= nums.length <= 10^5
     * -10^9 <= nums[i] <= 10^9
     * nums 是一个非递减数组
     * -10^9 <= target <= 10^9
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length < 1) {
            return result;
        }
        int left = 0;
        int right = nums.length;
        int find = -1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                find = mid;
                result[0] = find;
                result[1] = find;
                break;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (find != -1) {
            int left1 = left;
            int right1 = find;
            while (left1 < right1) {
                int mid = (left1 + right1) / 2;
                if (nums[mid] == target) {
                    result[0] = mid;
                    right1 = mid;
                } else {
                    left1 = mid + 1;
                }
            }
            int left2 = find + 1;
            int right2 = right;
            while (left2 < right2) {
                int mid = (left2 + right2) / 2;
                if (nums[mid] == target) {
                    result[1] = mid;
                    left2 = mid + 1;
                } else {
                    right2 = mid;
                }
            }
        }
        return result;
    }
}
