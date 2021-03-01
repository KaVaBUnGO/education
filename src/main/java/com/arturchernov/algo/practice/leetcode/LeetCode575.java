package com.arturchernov.algo.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 575. Distribute Candies
 * <p>
 * Alice has n candies, where the ith candy is of type candyType[i].
 * Alice noticed that she started to gain weight, so she visited a doctor.
 * <p>
 * The doctor advised Alice to only eat n / 2 of the candies she has (n is always even).
 * Alice likes her candies very much, and she wants to eat the maximum number of
 * different types of candies while still following the doctor's advice.
 * <p>
 * Given the integer array candyType of length n, return the maximum number of different types
 * of candies she can eat if she only eats n / 2 of them.
 */
public class LeetCode575 {

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(distributeCandies(new int[]{1, 1, 2, 3}));
        System.out.println(distributeCandies(new int[]{6, 6, 6, 6}));
    }

    public static int distributeCandies(int[] candyType) {
        Set<Integer> hs = new HashSet<>();
        for (Integer i : candyType) {
            hs.add(i);
        }
        return Math.min(hs.size(), candyType.length / 2);
    }
}