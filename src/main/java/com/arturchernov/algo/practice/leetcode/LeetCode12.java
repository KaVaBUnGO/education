package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 12. Integer to Roman
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together.
 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies to the number nine,
 * which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 */
public class LeetCode12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(1));
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(49));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(3999));
    }

    public static String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        int d = 1000;
        int a[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int it = 0;
        while (num > 0) {
            int k = a[it++];
            int p = num / k;
            if (p > 0) {
                String ch = getChar(k);
                ans.append(ch.repeat(p));
            }
            num %= k;
        }
        return ans.toString();
    }

    private static String getChar(int k) {
        switch (k) {
            case 1:
                return "I";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 90:
                return "XC";
            case 100:
                return "C";
            case 400:
                return "CD";
            case 500:
                return "D";
            case 900:
                return "CM";
            case 1000:
                return "M";
            default:
                return null;
        }
    }
}