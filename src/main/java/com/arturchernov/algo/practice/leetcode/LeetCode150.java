package com.arturchernov.algo.practice.leetcode;

import java.util.Stack;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 150. Evaluate Reverse Polish Notation
 * <p>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * <p>
 * Note that division between two integers should truncate toward zero.
 * <p>
 * It is guaranteed that the given RPN expression is always valid.
 * That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 * <p>
 * Example 1:
 * <p>
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * <p>
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * <p>
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * Constraints:
 * <p>
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
public class LeetCode150 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode150()).start();
    }

    @Override
    public void run() {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (!isOperation(token)) {
                st.add(Integer.parseInt(token));
            } else {
                Integer second = st.pop();
                Integer first = st.pop();
                st.add(apply(first, second, token.charAt(0)));
            }
        }
        return st.pop();
    }

    private boolean isOperation(String s) {
        if (s.length() > 1) return false;
        char c = s.charAt(0);
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private Integer apply(Integer first, Integer second, char operation) {
        switch (operation) {
            case '+': {
                return first + second;
            }
            case '-': {
                return first - second;
            }
            case '*': {
                return first * second;
            }
            case '/': {
                return first / second;
            }
            default: {
                throw new RuntimeException("Method not supported");
            }
        }
    }
}
