package leetcode;

/**
 * 12. 整数转罗马数字
 * https://leetcode.cn/problems/integer-to-roman/
 *
 * @author qiangfei
 * @date 2022/5/12 15:28
 */
public class Solution00012 {
    /**
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     *  
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给你一个整数，将其转为罗马数字。
     *  
     * 示例 1:
     * 输入: num = 3
     * 输出: "III"
     *  
     * 示例 2:
     * 输入: num = 4
     * 输出: "IV"
     *  
     * 示例 3:
     * 输入: num = 9
     * 输出: "IX"
     *  
     * 示例 4:
     * 输入: num = 58
     * 输出: "LVIII"
     * 解释: L = 50, V = 5, III = 3.
     * 示例 5:
     *  
     * 输入: num = 1994
     * 输出: "MCMXCIV"
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *  
     * 提示：
     * 1 <= num <= 3999
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        char[] sym = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int step = 1000;
        int rec = 0;
        int cur;
        while (step > 0) {
            cur = num / step;
            num = num % step;
            step /= 10;
            while (cur > 0) {
                if (cur == 9) {
                    sb.append(sym[rec]).append(sym[rec - 2]);
                    break;
                } else if (cur >= 5) {
                    sb.append(sym[rec - 1]);
                    cur -= 5;
                } else if (cur == 4) {
                    sb.append(sym[rec]).append(sym[rec - 1]);
                    break;
                } else {
                    sb.append(sym[rec]);
                    cur--;
                }
            }
            rec += 2;
        }
        return sb.toString();
    }
}
