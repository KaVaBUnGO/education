package com.arturchernov.algo.practice.leetcode;

import java.util.List;
import java.util.Stack;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 841. Keys and Rooms
 * <p>
 * There are N rooms and you start in room 0.  Each room has a distinct number
 * in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 * <p>
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer
 * in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 * <p>
 * Initially, all the rooms start locked (except for room 0).
 * <p>
 * You can walk back and forth between rooms freely.
 * <p>
 * Return true if and only if you can enter every room.
 */
public class LeetCode841 {

    public static void main(String[] args) {
        System.out.println(canVisitAllRooms(List.of(List.of())));
        System.out.println(canVisitAllRooms(List.of(List.of(), List.of())));
        System.out.println(canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
        System.out.println(canVisitAllRooms(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0))));
    }


    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] used = new boolean[rooms.size()];
        Stack<Integer> st = new Stack<>();
        used[0] = true;
        for (int i : rooms.get(0)) {
            st.push(i);
        }
        while (!st.isEmpty()) {
            int v = st.pop();
            if (used[v]) {
                continue;
            }
            used[v] = true;
            for (int i : rooms.get(v)) {
                if (!used[i]) {
                    st.push(i);
                }
            }
        }
        for (boolean t : used) {
            if (!t) {
                return false;
            }
        }
        return true;
    }
}