package leetcode;

/**
 * 43. 字符串相乘
 * https://leetcode.cn/problems/multiply-strings/
 *
 * @author qiangfei
 * @date 2022/5/19 19:25
 */
public class Solution00043 {
    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
     *   
     * 示例 1:
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     *   
     * 示例 2:
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     *   
     * 提示：
     * 1 <= num1.length, num2.length <= 200
     * num1 和 num2 只能由数字组成。
     * num1 和 num2 都不包含任何前导零，除了数字0本身。
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] result = new int[num1.length() + num2.length()];
        multiply2(num1, num2, result, 0);
        StringBuilder sb = new StringBuilder();
        if (result[result.length - 1] > 0) {
            sb.append(result[result.length - 1]);
        }
        for (int i = result.length - 2; i >= 0; --i) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    private void multiply2(String num1, String num2, int[] result, int offset) {
        int length1 = num1.length();
        int length2 = num2.length();
        if (length1 > 9) {
            multiply2(num1.substring(length1 - 9, length1), num2, result, offset);
            multiply2(num1.substring(0, length1 - 9), num2, result, 9 + offset);
            return;
        }
        if (length2 > 9) {
            multiply2(num1, num2.substring(length2 - 9, length2), result, offset);
            multiply2(num1, num2.substring(0, length2 - 9), result, 9 + offset);
            return;
        }
        long n1 = 0;
        char[] chars1 = num1.toCharArray();
        for (char c : chars1) {
            n1 = n1 * 10 + (c - '0');
        }
        long n2 = 0;
        char[] chars2 = num2.toCharArray();
        for (char c : chars2) {
            n2 = n2 * 10 + (c - '0');
        }
        long mul = n1 * n2;
        while (mul > 0) {
            mul += result[offset];
            result[offset++] = (int) (mul % 10);
            mul /= 10;
        }
    }

    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        int length1 = chars1.length;
        char[] chars2 = num2.toCharArray();
        int length2 = chars2.length;
        int[] result = new int[length1 + length2];
        for (int i = 0; i < length1; ++i) {
            int n1 = chars1[length1 - 1 - i] - '0';
            for (int j = 0; j < length2; ++j) {
                int mul = n1 * (chars2[length2 - 1 - j] - '0');
                int cur = i + j;
                while (mul > 0) {
                    mul += result[cur];
                    result[cur++] = mul % 10;
                    mul /= 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (result[result.length - 1] > 0) {
            sb.append(result[result.length - 1]);
        }
        for (int i = result.length - 2; i >= 0; --i) {
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
