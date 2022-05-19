package leetcode;

/**
 * 42. 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/
 *
 * @author qiangfei
 * @date 2022/5/19 19:15
 */
public class Solution00042 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *   
     * 示例 1：
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     *   
     * 示例 2：
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     *   
     * 提示：
     * n == height.length
     * 1 <= n <= 2 * 10^4
     * 0 <= height[i] <= 10^5
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int max = -1;
        for (int i = 0; i < height.length; ++i) {
            if (height[i] > max) {
                max = height[i];
            }
            leftMax[i] = max;
        }
        int sum = 0;
        max = -1;
        for (int i = height.length - 1; i >= 0; --i) {
            if (height[i] > max) {
                max = height[i];
            }
            sum += Math.min(max, leftMax[i]) - height[i];
        }
        return sum;
    }
}
