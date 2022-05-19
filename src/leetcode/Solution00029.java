package leetcode;

/**
 * 29. 两数相除
 * https://leetcode.cn/problems/divide-two-integers/
 *
 * @author qiangfei
 * @date 2022/5/16 10:18
 */
public class Solution00029 {
    /**
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     *   
     * 示例 1:
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
     *   
     * 示例 2:
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = truncate(-2.33333..) = -2
     *   
     * 提示：
     * 被除数和除数均为 32 位有符号整数。
     * 除数不为 0。
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        } else if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        boolean neg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        int result = divide2(Math.abs((long) dividend), Math.abs((long) divisor));
        return neg ? -result : result;
    }

    private int divide2(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        int max = 1;
        while (dividend - divisor >= divisor) {
            divisor = divisor << 1;
            max = max << 1;
        }
        int result = 0;
        while (max >= 1) {
            if (dividend >= divisor) {
                result += max;
                dividend -= divisor;
            }
            divisor = divisor >> 1;
            max = max >> 1;
        }
        return result;
    }
}
