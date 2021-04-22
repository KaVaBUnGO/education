package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 554. Brick Wall
 * <p>
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks.
 * The bricks have the same height but different width. You want to draw a vertical line from the
 * top to the bottom and cross the least bricks.
 * <p>
 * The brick wall is represented by a list of rows. Each row is a list of integers representing
 * the width of each brick in this row from left to right.
 * <p>
 * If your line go through the edge of a brick, then the brick is not considered as crossed.
 * You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 * <p>
 * You cannot draw a line just along one of the two vertical edges of the wall,
 * in which case the line will obviously cross no bricks.
 * <p>
 * Example:
 * <p>
 * Input: [[1,2,2,1],
 * [3,1,2],
 * [1,3,2],
 * [2,4],
 * [3,1,2],
 * [1,3,1,1]]
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * <p>
 * Note:
 * <p>
 * The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 * The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000].
 * Total number of bricks of the wall won't exceed 20,000.
 */
public class LeetCode554 {

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        int[][] data = new int[][]{{1, 2, 2, 1}, {3, 1, 2}, {1, 3, 2}, {2, 4}, {1, 3, 1, 1}};
        for (int i = 0; i < data.length; i++) {
            input.add(new ArrayList<>());
            for (int j = 0; j < data[i].length; j++) {
                input.get(i).add(data[i][j]);
            }
        }
        System.out.println(leastBricks(input));
    }

    public static int leastBricks(List<List<Integer>> a) {
        Map<Integer, Integer> hm = new HashMap<>();
        int h = a.size();
        int max = 0;
        for (int i = 0; i < h; i++) {
            int w = a.get(i).size();
            int k = 0;
            for (int j = 0; j < w - 1; j++) {
                k += a.get(i).get(j);
                if (hm.containsKey(k)) {
                    hm.put(k, hm.get(k) + 1);
                } else {
                    hm.put(k, 1);
                }
            }
        }
        int ans = h;
        for (int i : hm.values()) {
            ans = Math.min(ans, h - i);
        }
        return ans;
    }
}