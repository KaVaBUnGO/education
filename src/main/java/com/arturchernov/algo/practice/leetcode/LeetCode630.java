package com.arturchernov.algo.practice.leetcode;

import java.util.*;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 630. Course Schedule III
 * <p>
 * There are n different online courses numbered from 1 to n.
 * You are given an array courses where courses[i] = [durationi, lastDayi] indicate that the ith course
 * should be taken continuously for durationi days and must be finished before or on lastDayi.
 * <p>
 * You will start on the 1st day and you cannot take two or more courses simultaneously.
 * <p>
 * Return the maximum number of courses that you can take.
 * <p>
 * Example 1:
 * <p>
 * Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
 * Output: 3
 * Explanation:
 * There are totally 4 courses, but you can take 3 courses at most:
 * First, take the 1st course, it costs 100 days so you will finish it on the 100th day,
 * and ready to take the next course on the 101st day.
 * Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day,
 * and ready to take the next course on the 1101st day.
 * Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day.
 * The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.
 * Example 2:
 * <p>
 * Input: courses = [[1,2]]
 * Output: 1
 * Example 3:
 * <p>
 * Input: courses = [[3,2],[4,3]]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= courses.length <= 10^4
 * 1 <= durationi, lastDayi <= 10^4
 */
public class LeetCode630 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode630()).start();
    }

    @Override
    public void run() {
        System.out.println(scheduleCourse(LeetCodeUtils.buildMatrix("[[7,17],[3,12],[10,20],[9,10],[5,20],[10,19],[4,18]]")));
        System.out.println(scheduleCourse(LeetCodeUtils.buildMatrix("[[100,200],[200,1300],[1000,1250],[2000,3200]]")));
        System.out.println(scheduleCourse(LeetCodeUtils.buildMatrix("[[2000,3200],[100,200],[200,1300],[1000,1250]]")));
        System.out.println(scheduleCourse(LeetCodeUtils.buildMatrix("[[1,2]]")));
        System.out.println(scheduleCourse(LeetCodeUtils.buildMatrix("[[3,2],[4,3]]")));
    }

    public int scheduleCourse(int[][] a) {
        int len = a.length;
        Arrays.sort(a, Comparator.comparingInt(o -> o[1]));
        System.out.println("Current courses: " + Arrays.deepToString(a));
        int totalLen = 0;
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < len; i++) {
            if (totalLen + a[i][0] <= a[i][1]) {
                totalLen += a[i][0];
                q.add(a[i][0]);
                System.out.println("Added: " + Arrays.toString(a[i]));
            } else {
                if (q.size() > 0) {
                    int maxLen = q.peek();
                    if (maxLen > a[i][0]) {
                        System.out.println("Removed: " + maxLen);
                        totalLen = totalLen - maxLen + a[i][0];
                        q.poll();
                        q.add(a[i][0]);
                        System.out.println("Added: " + Arrays.toString(a[i]));
                    }
                }
            }
        }
        return q.size();
    }
}
