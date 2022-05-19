package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 36. 有效的数独
 * https://leetcode.cn/problems/valid-sudoku/
 *
 * @author qiangfei
 * @date 2022/5/19 10:28
 */
public class Solution00036 {
    /**
     * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     *   
     * 注意：
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 空白格用 '.' 表示。
     *   
     * 示例 1：
     * 输入：board =
     * [["5","3",".",".","7",".",".",".","."]
     * ,["6",".",".","1","9","5",".",".","."]
     * ,[".","9","8",".",".",".",".","6","."]
     * ,["8",".",".",".","6",".",".",".","3"]
     * ,["4",".",".","8",".","3",".",".","1"]
     * ,["7",".",".",".","2",".",".",".","6"]
     * ,[".","6",".",".",".",".","2","8","."]
     * ,[".",".",".","4","1","9",".",".","5"]
     * ,[".",".",".",".","8",".",".","7","9"]]
     * 输出：true
     *   
     * 示例 2：
     * 输入：board =
     * [["8","3",".",".","7",".",".",".","."]
     * ,["6",".",".","1","9","5",".",".","."]
     * ,[".","9","8",".",".",".",".","6","."]
     * ,["8",".",".",".","6",".",".",".","3"]
     * ,["4",".",".","8",".","3",".",".","1"]
     * ,["7",".",".",".","2",".",".",".","6"]
     * ,[".","6",".",".",".",".","2","8","."]
     * ,[".",".",".","4","1","9",".",".","5"]
     * ,[".",".",".",".","8",".",".","7","9"]]
     * 输出：false
     * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
     *  
     * 提示：
     *   
     * board.length == 9
     * board[i].length == 9
     * board[i][j] 是一位数字（1-9）或者 '.'
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        List[] list = new List[9];
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; ++j) {
                char c = chars[j];
                if (c == '.') {
                    continue;
                }
                List existed = list[c - '1'];
                if (existed == null) {
                    existed = new ArrayList<>();
                    list[c - '1'] = existed;
                } else {
                    for (Object pos : existed) {
                        if (!isValid((int) pos, i, j)) {
                            return false;
                        }
                    }
                }
                existed.add(i * 9 + j);

            }
        }
        return true;
    }

    private boolean isValid(int pos, int i, int j) {
        if (i == pos / 9) {
            return false;
        }
        if (j == pos % 9) {
            return false;
        }
        int left = (i / 3 * 3) * 9 + j / 3 * 3;
        for (int k = 0; k < 3; ++k) {
            if (left + 9 * k <= pos && left + 9 * k + 2 >= pos) {
                return false;
            }
        }
        return true;
    }
}
