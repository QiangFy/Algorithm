package leetcode;

/**
 * 6. Z 字形变换
 * https://leetcode.cn/problems/zigzag-conversion/
 *
 * @author qiangfei
 * @date 2022/5/11 21:54
 */
public class Solution00006 {
    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     *  
     * 示例 1：
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     *  
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     *  
     * 示例 3：
     * 输入：s = "A", numRows = 1
     * 输出："A"
     *  
     * 提示：
     * 1 <= s.length <= 1000
     * s 由英文字母（小写和大写）、',' 和 '.' 组成
     * 1 <= numRows <= 1000
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int step = 2 * numRows - 2;
        for (int i = 0; i < chars.length; i += step) {
            sb.append(chars[i]);
        }
        for (int i = 1; i < numRows - 1; ++i) {
            for (int j = i; j < chars.length; j += step) {
                sb.append(chars[j]);
                if (j + step - 2 * i < chars.length) {
                    sb.append(chars[j + step - i * 2]);
                }
            }
        }
        for (int i = numRows - 1; i < chars.length; i += step) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
