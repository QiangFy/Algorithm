package leetcode;

/**
 * 50. Pow(x, n)
 * https://leetcode.cn/problems/powx-n/
 *
 * @author qiangfei
 * @date 2022/5/20 13:51
 */
public class Solution00050 {
    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
     * <p>
     * 示例 1：
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     * <p>
     * 示例 2：
     * 输入：x = 2.10000, n = 3
     * 输出：9.26100
     * <p>
     * 示例 3：
     * 输入：x = 2.00000, n = -2
     * 输出：0.25000
     * 解释：2-2 = 1/22 = 1/4 = 0.25
     * <p>
     * 提示：
     * -100.0 < x < 100.0
     * -2^31 <= n <= 2^31-1
     * -10^4 <= x^n <= 10^4
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        }
        double pow = myPow(x * x, n >> 1);
        if ((n & 1) != 0) {
            pow *= x;
        }
        return pow;
    }
}
