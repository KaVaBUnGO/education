package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 51. N-Queens
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
 * both indicate a queen and an empty space, respectively.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: [["Q"]]
 */
public class LeetCode51 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode51()).start();
    }

    @Override
    public void run() {
        System.out.println(solveNQueens(4));
        System.out.println(solveNQueens(8));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n == 0) return ans;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        search(board, 0, ans, n);
        return ans;
    }

    private void search(char[][] board, int row, List<List<String>> ans, int n) {
        if (row == n) {
            ans.add(result(board, n));
            return;
        }
        for (int col = 0; col < n; col++) {
            board[row][col] = 'Q';
            if (check(board, row, col, n)) {
                search(board, row + 1, ans, n);
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

    private List<String> result(char[][] board, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new String(board[i]));
        }
        return list;
    }
}
