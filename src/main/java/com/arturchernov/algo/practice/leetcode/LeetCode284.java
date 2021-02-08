package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 284. Peeking Iterator
 * <p>
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that
 * support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 */
public class LeetCode284 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        PeekingIterator it = new PeekingIterator(list.iterator());
        System.out.println(it.next());
        System.out.println(it.peek());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());

        System.out.println();

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);
        PeekingIterator it2 = new PeekingIterator(list2.iterator());
        System.out.println(it2.hasNext());
        System.out.println(it2.peek());
        System.out.println(it2.peek());
        System.out.println(it2.next());
        System.out.println(it2.next());
        System.out.println(it2.peek());
        System.out.println(it2.peek());
        System.out.println(it2.next());
        System.out.println(it2.hasNext());
        System.out.println(it2.peek());
        System.out.println(it2.hasNext());
        System.out.println(it2.next());
        System.out.println(it2.hasNext());
    }

    static class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> it;
        Integer next = null;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            it = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (this.next != null) {
                return this.next;
            }
            this.next = it.next();
            return this.next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (next != null) {
                Integer temp = this.next;
                this.next = null;
                return temp;
            }
            return it.next();
        }

        @Override
        public boolean hasNext() {
            if (next != null) {
                return true;
            }
            return it.hasNext();
        }
    }
}