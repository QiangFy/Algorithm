package leetcode;

/**
 * 41. 缺失的第一个正数
 * https://leetcode.cn/problems/first-missing-positive/
 *
 * @author qiangfei
 * @date 2022/5/19 18:53
 */
public class Solution00041 {
    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     *  
     * 示例 1：
     * 输入：nums = [1,2,0]
     * 输出：3
     *   
     * 示例 2：
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     *   
     * 示例 3：
     * 输入：nums = [7,8,9,11,12]
     * 输出：1
     *  
     * 提示：
     * 1 <= nums.length <= 5 * 10^5
     * -2^31 <= nums[i] <= 2^31 - 1
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; ++i) {
            int num = nums[i];
            while (num > 0 && num != i + 1 && num <= length) {
                int temp = nums[num - 1];
                if (temp == num) {
                    break;
                }
                nums[num - 1] = num;
                num = temp;
            }
            nums[i] = num;
        }
        for (int i = 0; i < length; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }
}
