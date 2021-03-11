package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 322. Coin Change
 * <p>
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 */
public class LeetCode322 {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1}, 0));
        System.out.println(coinChange(new int[]{1}, 1));
        System.out.println(coinChange(new int[]{1}, 2));
        System.out.println(coinChange(new int[]{1}, 10000));
        System.out.println(coinChange(new int[]{324234234}, 10000));
        System.out.println(coinChange(new int[]{1, 2147483647}, 2));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] mas = new int[10001];
        Arrays.fill(mas, Integer.MAX_VALUE);
        mas[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            if (mas[i] == Integer.MAX_VALUE) {
                continue;
            }
            for (int coin : coins) {
                if (coin > amount) {
                    continue;
                }
                if (i + coin < mas.length && mas[i + coin] > mas[i] + 1) {
                    mas[i + coin] = mas[i] + 1;
                }
            }
        }
        return mas[amount] == Integer.MAX_VALUE ? -1 : mas[amount];
    }
}