package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 318. Maximum Product of Word Lengths
 * <p>
 * Given a string array words, return the maximum value of length(word[i]) * length(word[j])
 * where the two words do not share common letters. If no such two words exist, return 0.
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * Example 2:
 * <p>
 * Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * Example 3:
 * <p>
 * Input: words = ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 * <p>
 * Constraints:
 * <p>
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] consists only of lowercase English letters.
 */
public class LeetCode318 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode318()).start();
    }

    @Override
    public void run() {
        System.out.println(maxProduct(new String[]{"bdcecbcadca", "caafd", "bcadc", "eaedfcd", "fcdecf", "dee", "bfedd", "ffafd", "eceaffa", "caabe", "fbdb", "acafbccaa", "cdc", "ecfdebaafde", "cddbabf", "adc", "cccce", "cbbe", "beedf", "fafbfdcb", "ceecfabedbd", "aadbedeaf", "cffdcfde", "fbbdfdccce", "ccada", "fb", "fa", "ec", "dddafded", "accdda", "acaad", "ba", "dabe", "cdfcaa", "caadfedd", "dcdcab", "fadbabace", "edfdb", "dbaaffdfa", "efdffceeeb", "aefdf", "fbadcfcc", "dcaeddd", "baeb", "beddeed", "fbfdffa", "eecacbbd", "fcde", "fcdb", "eac", "aceffea", "ebabfffdaab", "eedbd", "fdeed", "aeb", "fbb", "ad", "bcafdabfbdc", "cfcdf", "deadfed", "acdadbdcdb", "fcbdbeeb", "cbeb", "acbcafca", "abbcbcbaef", "aadcafddf", "bd", "edcebadec", "cdcbabbdacc", "adabaea", "dcebf", "ffacdaeaeeb", "afedfcadbb", "aecccdfbaff", "dfcfda", "febb", "bfffcaa", "dffdbcbeacf", "cfa", "eedeadfafd", "fcaa", "addbcad", "eeaaa", "af", "fafc", "bedbbbdfae", "adfecadcabe", "efffdaa", "bafbcbcbe", "fcafabcc", "ec", "dbddd", "edfaeabecee", "fcbedad", "abcddfbc", "afdafb", "afe", "cdad", "abdffbc", "dbdbebdbb"}));
        System.out.println(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
    }

    public int maxProduct(String[] words) {
        List<Pair> list = new ArrayList<>();
        for (String w : words) {
            Set<Character> set = new HashSet<>();
            char[] chars = w.toCharArray();
            for (char ch : chars) {
                set.add(ch);
            }
            if (set.size() < 26) {
                list.add(new Pair(set, w.length()));
            }
        }

        int ans = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (!isIntersect(list.get(i).hash, list.get(j).hash)) {
                    ans = Math.max(ans, list.get(i).len * list.get(j).len);
                }
            }
        }

        return ans;
    }

    private boolean isIntersect(Set<Character> s1, Set<Character> s2) {
        for (char ch : s1) {
            if (s2.contains(ch)) {
                return true;
            }
        }
        return false;
    }

    static class Pair {
        Set<Character> hash;
        int len;

        public Pair(Set<Character> hash, int len) {
            this.hash = hash;
            this.len = len;
        }
    }

}
