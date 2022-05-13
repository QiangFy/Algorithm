package leetcode;

/**
 * 4. 寻找两个正序数组的中位数
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 *
 * @author qiangfei
 * @date 2022/5/11 17:49
 */
public class Solution00004 {
    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     *  
     * 示例 1：
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     *  
     * 示例 2：
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     *  
     * 提示：
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -10^6 <= nums1[i], nums2[i] <= 10^6
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 > length2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left1 = 0;
        int right1 = length1;
        while (left1 <= right1) {
            int mid1 = (left1 + right1) / 2;
            int mid2 = (length1 + length2) / 2 - mid1;

            if (mid1 != 0 && mid2 != length2 && nums1[mid1 - 1] > nums2[mid2]) {
                right1 = mid1 - 1;
            } else if (mid1 != length1 && mid2 != 0 && nums1[mid1] < nums2[mid2 - 1]) {
                left1 = mid1 + 1;
            } else {
                int minRight;
                if (mid1 == length1) {
                    minRight = nums2[mid2];
                } else if (mid2 == length2) {
                    minRight = nums1[mid1];
                } else {
                    minRight = Math.min(nums1[mid1], nums2[mid2]);
                }
                if ((length1 + length2) % 2 == 1) {
                    return minRight;
                }

                int maxLeft;
                if (mid1 == 0) {
                    maxLeft = nums2[mid2 - 1];
                } else if (mid2 == 0) {
                    maxLeft = nums1[mid1 - 1];
                } else {
                    maxLeft = Math.max(nums1[mid1 - 1], nums2[mid2 - 1]);
                }
                return ((double) minRight + maxLeft) / 2;
            }
        }
        return 0.0;
    }
}
