package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1423. Maximum Points You Can Obtain from Cards
 * <p>
 * There are several cards arranged in a row, and each card has an associated number of points
 * The points are given in the integer array cardPoints.
 * <p>
 * In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
 * <p>
 * Your score is the sum of the points of the cards you have taken.
 * <p>
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 * <p>
 * Example 1:
 * <p>
 * Input: cardPoints = [1,2,3,4,5,6,1], k = 3
 * Output: 12
 * Explanation: After the first step, your score will always be 1. However,
 * choosing the rightmost card first will maximize your total score.
 * The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
 * <p>
 * Example 2:
 * <p>
 * Input: cardPoints = [2,2,2], k = 2
 * Output: 4
 * Explanation: Regardless of which two cards you take, your score will always be 4.
 * Example 3:
 * <p>
 * Input: cardPoints = [9,7,7,9,7,7,9], k = 7
 * Output: 55
 * Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 * Example 4:
 * <p>
 * Input: cardPoints = [1,1000,1], k = 1
 * Output: 1
 * Explanation: You cannot take the card in the middle. Your best score is 1.
 * Example 5:
 * <p>
 * Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * Output: 202
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 */
public class LeetCode1423 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode1423()).start();
    }

    @Override
    public void run() {
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(maxScore(new int[]{2, 2, 2}, 2));
        System.out.println(maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
        System.out.println(maxScore(new int[]{1, 1000, 1}, 1));
        System.out.println(maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }

    public int maxScore(int[] a, int k) {
        int len = a.length;
        int sum = 0;
        int it = k - 1;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        int ans = sum;
        while (it >= 0) {
            sum -= a[it];
            sum += a[len - k + it];
            ans = Math.max(ans, sum);
            --it;
        }
        return ans;
    }
}
