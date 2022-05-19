package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 37. 解数独
 * https://leetcode.cn/problems/sudoku-solver/
 *
 * @author qiangfei
 * @date 2022/5/19 14:51
 */
public class Solution00037 {
    /**
     * 编写一个程序，通过填充空格来解决数独问题。
     * 数独的解法需 遵循如下规则：
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
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
     * 输出：
     * [["5","3","4","6","7","8","9","1","2"]
     * ,["6","7","2","1","9","5","3","4","8"]
     * ,["1","9","8","3","4","2","5","6","7"]
     * ,["8","5","9","7","6","1","4","2","3"]
     * ,["4","2","6","8","5","3","7","9","1"]
     * ,["7","1","3","9","2","4","8","5","6"]
     * ,["9","6","1","5","3","7","2","8","4"]
     * ,["2","8","7","4","1","9","6","3","5"]
     * ,["3","4","5","2","8","6","1","7","9"]]
     * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
     *   
     * 提示：
     * board.length == 9
     * board[i].length == 9
     * board[i][j] 是一位数字或者 '.'
     * 题目数据 保证 输入数独仅有一个解
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
//        初始占位
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    fill(i, j, board[i][j] - '1');
                }
            }
        }

//        把可以唯一确定的数字先填写好
        while (true) {
            boolean modified = false;
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
//                        mask & (mask - 1) 可以移除最低位
//                        000010010 & 000010001 != 0
//                        000010000 & 000001111 == 0
                        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
                        if ((mask & (mask - 1)) == 0) {
                            int digit = Integer.bitCount(mask - 1);
                            fill(i, j, digit);
                            board[i][j] = (char) (digit + '1');
                            modified = true;
                        }
                    }
                }
            }
            if (!modified) {
                break;
            }
        }

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                }
            }
        }

        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0];
        int j = space[1];
        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
//        递归填写数字尝试
//        mask &= (mask - 1) 可以移除最低位
        for (; mask != 0 && !valid; mask &= (mask - 1)) {
            int digit = Integer.bitCount(mask ^ mask - 1) - 1;
            fill(i, j, digit);
            board[i][j] = (char) (digit + '1');
            dfs(board, pos + 1);
            remove(i, j, digit);
        }
    }

    private void fill(int i, int j, int digit) {
        int num = 1 << digit;
        line[i] = line[i] | num;
        column[j] = column[j] | num;
        block[i / 3][j / 3] = block[i / 3][j / 3] | num;
    }

    private void remove(int i, int j, int digit) {
        int num = 1 << digit;
        line[i] = line[i] & (0x1ff ^ num);
        column[j] = column[j] & (0x1ff ^ num);
        block[i / 3][j / 3] = block[i / 3][j / 3] & (0x1ff ^ num);
    }

    // 构建BitMap，记录每一行，每一列，每一块的占位
    private int[] line = new int[9];
    private int[] column = new int[9];
    private int[][] block = new int[3][3];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<>();
}
