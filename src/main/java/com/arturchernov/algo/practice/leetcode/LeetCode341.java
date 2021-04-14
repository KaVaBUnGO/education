package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 341. Flatten Nested List Iterator
 * <p>
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements
 * may also be integers or other lists. Implement an iterator to flatten it.
 * <p>
 * Implement the NestedIterator class:
 * <p>
 * NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
 * int next() Returns the next integer in the nested list.
 * boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
 */
public class LeetCode341 {

    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>() {{
            add(new NestedIntegerImpl(new int[]{1, 1}));
            add(new NestedIntegerImpl(2));
            add(new NestedIntegerImpl(new int[]{1, 1}));
        }};
        NestedIterator i = new NestedIterator(nestedList);
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
    }


    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return empty list if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    public static interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    public static class NestedIntegerImpl implements NestedInteger {
        private boolean isList = false;
        private Integer val;
        private List<NestedInteger> list;

        public NestedIntegerImpl(Integer val) {
            this.val = val;
        }

        public NestedIntegerImpl(int[] a) {
            isList = true;
            List<NestedInteger> list = new ArrayList<>();
            for (Integer val : a) {
                list.add(new NestedIntegerImpl(val));
            }
            this.list = list;
        }

        @Override
        public boolean isInteger() {
            return !isList;
        }

        @Override
        public Integer getInteger() {
            if (isList) {
                return null;
            }
            return val;
        }

        @Override
        public List<NestedInteger> getList() {
            if (!isList) {
                Collections.emptyList();
            }
            return list;
        }
    }

    public static class NestedIterator implements Iterator<Integer> {

        private List<Integer> list = new ArrayList<>();
        private int cursor = 0;

        public NestedIterator(List<NestedInteger> nestedList) {
            buildList(nestedList);
        }

        private void buildList(List<NestedInteger> list) {
            for (NestedInteger i : list) {
                if (i.isInteger()) {
                    this.list.add(i.getInteger());
                } else {
                    buildList(i.getList());
                }
            }
        }

        @Override
        public Integer next() {
            if (cursor < list.size()) {
                return list.get(cursor++);
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return cursor != list.size();
        }
    }
}