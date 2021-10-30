package 回溯;

import java.util.List;

/**
 * @author CoderZk
 */
public class _51_N皇后 {
    /**
     * 数组索引是行号, 数组元素是列号 clos[4] = 5 表示 第4行的皇后在第5列
     * cols[row] = col
     */
    int[] cols;
    /**
     * 一共有多少种摆法
     */
    int ways;

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return null;
        }
        cols = new int[n];
        place(0);
        System.out.println(n + "皇后一共有" + ways + "种摆法");
        return null;
    }

    /**
     * 从第 row 行开始摆放皇后
     *
     * @param row
     */
    void place(int row) {
        if (row == cols.length) {
            ways++;
            show();
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                // 在第 row 行, 第 col 列摆放皇后
                cols[row] = col;
                place(row + 1); // 递归返回, 回溯, for循环继续选择
            }
        }
    }

    /**
     * 判断第 row 行, 第 col 列是否可以摆放皇后
     */
    boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 第 col 列已经有皇后
            if (cols[i] == col) {
                return false;
            }
            // 第 i 行的皇后跟第 row 行第col列格子处于同一斜线上
            if (row - i == Math.abs(col - cols[i])) {
                return false;
            }
        }
        return true;
    }

    void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    System.out.println("1 ");
                } else {
                    System.out.println("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }
}
