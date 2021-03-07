package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 706. Design HashMap
 * <p>
 * Design a HashMap without using any built-in hash table libraries.
 * <p>
 * To be specific, your design should include these functions:
 * <p>
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap,
 * update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 */
public class LeetCode706 {

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));            // returns 1
        System.out.println(hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2));            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));            // returns -1 (not found)
    }

    static class MyHashMap {

        private ArrayList<LinkedList<Pair>> map;
        int capacity = 1000;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            map = new ArrayList<>();
            for (int i = 0; i < capacity; i++) {
                map.add(new LinkedList<>());
            }
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int hash = Objects.hash(key);
            int pos = hash % capacity;
            LinkedList<Pair> list = map.get(pos);
            boolean found = false;
            for (Pair pair : list) {
                if (pair.key == key) {
                    pair.value = value;
                    found = true;
                }
            }
            if (!found) {
                list.add(new Pair(key, value));
            }
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            int hash = Objects.hash(key);
            int pos = hash % capacity;
            LinkedList<Pair> list = map.get(pos);
            for (Pair pair : list) {
                if (pair.key == key) {
                    return pair.value;
                }
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int hash = Objects.hash(key);
            int pos = hash % capacity;
            LinkedList<Pair> list = map.get(pos);
            list.removeIf(pair -> pair.key == key);
        }
    }

    private static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}