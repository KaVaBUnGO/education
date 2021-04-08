package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1551. Minimum Operations to Make Array Equal
 * <p>
 * You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).
 * <p>
 * In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add
 * 1 to arr[y] (i.e. perform arr[x] -=1 and arr[y] += 1). The goal is to make all the elements of the array equal.
 * It is guaranteed that all the elements of the array can be made equal using some operations.
 * <p>
 * Given an integer n, the length of the array.
 * Return the minimum number of operations needed to make all the elements of arr equal.
 */
public class LeetCode1551 {

    public static void main(String[] args) {
        System.out.println(minOperations(1));
        System.out.println(minOperations(2));
        System.out.println(minOperations(3));
        System.out.println(minOperations(4));
        System.out.println(minOperations(5));
        System.out.println(minOperations(6));
        System.out.println(minOperations(7));
    }

    public static int minOperations(int n) {
        if (n % 2 == 1) {
            return (n - 1) * (n + 1) / 4;
        } else {
            return n * n / 4;
        }
    }
}