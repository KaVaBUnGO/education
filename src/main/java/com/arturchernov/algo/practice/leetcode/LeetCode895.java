package com.arturchernov.algo.practice.leetcode;

import java.util.*;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 895. Maximum Frequency Stack
 * <p>
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 * <p>
 * FreqStack has two functions:
 * <p>
 * push(int x), which pushes an integer x onto the stack.
 * pop(), which removes and returns the most frequent element in the stack.
 * If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 */
public class LeetCode895 {

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        populate(new String[]{"push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"},
                new int[]{5, 7, 5, 7, 4, 5}, freqStack);

    }

    private static void populate(String[] actions, int[] elements, FreqStack st) {
        int it = 0;
        for (String action : actions) {
            if (action.equals("push")) {
                st.push(elements[it++]);
            } else {
                System.out.println(st.pop());
            }
        }
    }

    static class FreqStack {
        int pos = 0;
        Set<Element> ts = new TreeSet<>();
        Map<Integer, Element> map = new TreeMap<>();


        public FreqStack() {
        }

        public void push(int x) {
            if (map.containsKey(x)) {
                Element e = map.get(x);
                ts.remove(e);
                ts.add(e.inc(pos++));
                map.put(x, e);
            } else {
                Element e = new Element(x, pos++);
                ts.add(e);
                map.put(x, e);
            }
        }

        public int pop() {
            Element e = ts.iterator().next();
            ts.remove(e);
            if (e.canDec()) {
                e.dec();
                map.put(e.val, e);
                ts.add(e);
            } else {
                map.remove(e.val);
            }
            return e.val;
        }
    }

    static class Element implements Comparable<Element> {
        int freq;
        int val;
        List<Integer> pos = new ArrayList<>();

        public Element(int val, int pos) {
            this.val = val;
            this.pos.add(pos);
            this.freq = 1;
        }

        public Element inc(int pos) {
            this.freq++;
            this.pos.add(pos);
            return this;
        }

        public void dec() {
            this.freq--;
            this.pos.remove(this.pos.size() - 1);
        }

        public boolean canDec() {
            return this.freq > 1;
        }

        @Override
        public int compareTo(Element o) {
            if (o.freq > this.freq) {
                return 1;
            } else if (o.freq < this.freq) {
                return -1;
            } else {
                if (o.val == this.val) {
                    return 0;
                }
                if (o.pos.get(o.pos.size() - 1) > this.pos.get(this.pos.size() - 1)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }

    }
}