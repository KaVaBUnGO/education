package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 936. Stamping The Sequence
 * <p>
 * You want to form a target string of lowercase letters.
 * <p>
 * At the beginning, your sequence is target.length '?' marks.  You also have a stamp of lowercase letters.
 * <p>
 * On each turn, you may place the stamp over the sequence, and replace every letter in the sequence with the
 * corresponding letter from the stamp.  You can make up to 10 * target.length turns.
 * <p>
 * For example, if the initial sequence is "?????", and your stamp is "abc",
 * then you may make "abc??", "?abc?", "??abc" in the first turn.
 * (Note that the stamp must be fully contained in the boundaries of the sequence in order to stamp.)
 * <p>
 * If the sequence is possible to stamp, then return an array of the index of the left-most letter
 * being stamped at each turn.  If the sequence is not possible to stamp, return an empty array.
 * <p>
 * For example, if the sequence is "ababc", and the stamp is "abc", then we could return the answer
 * [0, 2], corresponding to the moves "?????" -> "abc??" -> "ababc".
 * <p>
 * Also, if the sequence is possible to stamp, it is guaranteed it is possible to stamp within 10 * target.length moves.
 * Any answers specifying more than this number of moves will not be accepted.
 * <p>
 * Example 1:
 * <p>
 * Input: stamp = "abc", target = "ababc"
 * Output: [0,2]
 * ([1,0,2] would also be accepted as an answer, as well as some other answers.)
 * Example 2:
 * <p>
 * Input: stamp = "abca", target = "aabcaca"
 * Output: [3,0,1]
 * <p>
 * Note:
 * 1 <= stamp.length <= target.length <= 1000
 * stamp and target only contain lowercase letters.
 */
public class LeetCode936 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(movesToStamp("mda", "mdadddaaaa")));
        System.out.println(Arrays.toString(movesToStamp("aye", "eyeye")));
        System.out.println(Arrays.toString(movesToStamp("abc", "ababc")));
        System.out.println(Arrays.toString(movesToStamp("abca", "aabcaca")));
    }

    public static int[] movesToStamp(String stamp, String target) {
        char[] s = target.toCharArray();
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        boolean found = true;
        while (count < s.length && found) {
            found = false;
            for (int i = 0; i <= s.length - stamp.length(); i++) {
                boolean canStamp = true;
                int k = 0;
                for (int j = 0; j < stamp.length(); j++) {
                    if (s[i + j] != '?' && stamp.charAt(j) != s[i + j]) {
                        canStamp = false;
                        break;
                    }
                    if (s[i + j] == '?') {
                        k++;
                    }
                }
                if (canStamp && k != stamp.length()) {
                    for (int j = 0; j < stamp.length(); j++) {
                        if (s[i + j] != '?') {
                            s[i + j] = '?';
                            count++;
                        }
                    }
                    found = true;
                    ans.add(i);
                }
            }
        }
        if (count == s.length) {
            Collections.reverse(ans);
            return ans.stream().mapToInt(i -> i).toArray();
        } else {
            return new int[0];
        }
    }
}