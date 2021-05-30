package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 52. N-Queens II
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no
 * two queens attack each other.
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: 1
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 9
 */
public class LeetCode52 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode52()).start();
    }

    @Override
    public void run() {
        System.out.println(totalNQueens(1));
        ans = 0;
        System.out.println(totalNQueens(2));
        ans = 0;
        System.out.println(totalNQueens(3));
        ans = 0;
        System.out.println(totalNQueens(8));
        ans = 0;
        System.out.println(totalNQueens(9));
    }

    private Integer ans = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        search(board, 0, n);
        return ans;
    }

    private void search(char[][] board, int row, int n) {
        if (row == n) {
            ++ans;
            return;
        }
        for (int col = 0; col < n; col++) {
            board[row][col] = 'Q';
            if (check(board, row, col, n)) {
                search(board, row + 1, n);
            }
            board[row][col] = '.';
        }
    }

    private boolean check(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < n; j++) {
                if ((col == j || Math.abs(row - i) == Math.abs(col - j)) && board[i][j] == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }
}
