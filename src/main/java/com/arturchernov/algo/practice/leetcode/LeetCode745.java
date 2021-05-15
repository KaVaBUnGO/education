package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 745. Prefix and Suffix Search
 * <p>
 * Design a special dictionary which has some words and allows you to search the words in it by a prefix and a suffix.
 * <p>
 * Implement the WordFilter class:
 * <p>
 * WordFilter(string[] words) Initializes the object with the words in the dictionary.
 * f(string prefix, string suffix) Returns the index of the word in the dictionary which has the prefix prefix
 * and the suffix suffix. If there is more than one valid index, return the largest of them.
 * If there is no such word in the dictionary, return -1.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["WordFilter", "f"]
 * [[["apple"]], ["a", "e"]]
 * Output
 * [null, 0]
 * <p>
 * Explanation
 * WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = "a" and suffix = 'e".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 15000
 * 1 <= words[i].length <= 10
 * 1 <= prefix.length, suffix.length <= 10
 * words[i], prefix and suffix consist of lower-case English letters only.
 * At most 15000 calls will be made to the function f.
 */
public class LeetCode745 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode745()).start();
    }

    @Override
    public void run() {
        WordFilter wordFilter = new WordFilter(new String[]{"applf", "apple"});
        System.out.println(wordFilter.f("a", "e"));
    }

    static class TreeNode745 {
        public TreeNode745[] children = new TreeNode745[26];
        public List<Integer> vals = new ArrayList<>();
    }

    static class WordFilter {
        private TreeNode745 pRoot = new TreeNode745();
        private TreeNode745 sRoot = new TreeNode745();

        public WordFilter(String[] words) {
            int size = words.length;
            for (int i = 0; i < size; i++) {
                char[] word = words[i].toCharArray();
                insert(word, i, pRoot, 0, word.length, 1);
                insert(word, i, sRoot, word.length - 1, -1, -1);
            }
        }

        private void insert(char[] word, int index, TreeNode745 trie, int start, int end, int step) {
            for (int i = start; i != end; i += step) {
                int c = word[i] - 'a';
                if (trie.children[c] == null) {
                    trie.children[c] = new TreeNode745();
                }
                trie = trie.children[c];
                trie.vals.add(index);
            }
        }

        private List<Integer> find(char[] w, TreeNode745 trie, int start, int end, int step) {
            for (int i = start; i != end; i += step) {
                trie = trie.children[w[i] - 'a'];
                if (trie == null) {
                    return new ArrayList<>();
                }
            }
            return trie.vals;
        }

        public int f(String prefix, String suffix) {
            List<Integer> first = find(prefix.toCharArray(), pRoot, 0, prefix.length(), 1);
            List<Integer> second = find(suffix.toCharArray(), sRoot, suffix.length() - 1, -1, -1);
            int fLen = first.size() - 1, sLen = second.size() - 1;
            while (fLen >= 0 && sLen >= 0) {
                int fIndex = first.get(fLen);
                int sIndex = second.get(sLen);
                if (fIndex == sIndex) {
                    return fIndex;
                }
                if (fIndex > sIndex) {
                    fLen--;
                } else {
                    sLen--;
                }
            }
            return -1;
        }
    }
}
