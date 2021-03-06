package leetcode;

/**
 * 7. 整数反转
 * https://leetcode.cn/problems/reverse-integer/
 *
 * @author qiangfei
 * @date 2022/5/11 22:41
 */
public class Solution00007 {
    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *  
     * 示例 1：
     * 输入：x = 123
     * 输出：321
     *  
     * 示例 2：
     * 输入：x = -123
     * 输出：-321
     *  
     * 示例 3：
     * 输入：x = 120
     * 输出：21
     *  
     * 示例 4：
     * 输入：x = 0
     * 输出：0
     *  
     * 提示：
     * -2^31 <= x <= 2^31 - 1
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result > 214748364 || (result == 214748364 && x % 10 > 7)) {
                return 0;
            }
            if (result < -214748364 || (result == -214748364 && x % 10 < -8)) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }
}
