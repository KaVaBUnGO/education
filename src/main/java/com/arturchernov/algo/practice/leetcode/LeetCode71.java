package com.arturchernov.algo.practice.leetcode;

import java.util.Stack;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 71. Simplify Path
 * <p>
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style
 * file system, convert it to the simplified canonical path.
 * <p>
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the
 * directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
 * For this problem, any other format of periods such as '...' are treated as file/directory names.
 * <p>
 * The canonical path should have the following format:
 * <p>
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory
 * (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 */
public class LeetCode71 {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }

    public static String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> st = new Stack<>();
        for (String part : parts) {
            if (part.length() == 0) {
                continue;
            }
            switch (part) {
                case ".":
                    break;
                case "..":
                    if (!st.isEmpty()) {
                        st.pop();
                    }
                    break;
                default:
                    st.push(part);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder(st.size());
        for (String s : st) {
            sb.append("/");
            sb.append(s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}