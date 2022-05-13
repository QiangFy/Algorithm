package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode.cn/problems/3sum/
 *
 * @author qiangfei
 * @date 2022/5/12 17:17
 */
public class Solution00015 {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     *  
     * 示例 1：
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     *  
     * 示例 2：
     * 输入：nums = []
     * 输出：[]
     *  
     * 示例 3：
     * 输入：nums = [0]
     * 输出：[]
     *  
     * 提示：
     * 0 <= nums.length <= 3000
     * -10^5 <= nums[i] <= 10^5
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            if (nums[i] > 0) {
                break;
            }
            int l = i + 1;
            int r = nums.length - 1;
//            双指针
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
//                    匹配上了，才能两端滑动，不然会错过num[l]==num[r]的情况
                    while (l < r && nums[l] == nums[l + 1]) {
                        ++l;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        --r;
                    }
                    ++l;
                    --r;
                } else if (sum < 0) {
                    ++l;
                } else {
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
