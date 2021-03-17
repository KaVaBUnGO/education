package com.arturchernov.algo.practice.leetcode;

import java.util.Random;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 478. Generate Random Point in a Circle
 * <p>
 * Given the radius and x-y positions of the center of a circle, write a function
 * randPoint which generates a uniform random point in the circle.
 * <p>
 * Note:
 * <p>
 * input and output values are in floating-point.
 * radius and x-y position of the center of the circle is passed into the class constructor.
 * a point on the circumference of the circle is considered to be in the circle.
 * randPoint returns a size 2 array containing x-position and y-position of the random point, in that order.
 */
public class LeetCode478 {

    public static void main(String[] args) {
        double r = 0.01;
        double center_x = -73839.1;
        double center_y = -3289891.3;
        Solution solution = new Solution(r, center_x, center_y);
        int it = 0;
        while (it++ < 1000000) {
            double[] a = solution.randPoint();
            double d = Math.sqrt(Math.pow(center_x - a[0], 2) + Math.pow(center_y - a[1], 2));
            if (Math.abs(r-d)<0.01) {
                System.out.println("Error: x: " + a[0] + ", y: " + a[1]);
            }
        }
    }

    static class Solution {
        private final Random random = new Random();
        private double radius;
        private double x_center;
        private double y_center;

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
        }

        public double[] randPoint() {
            double angle = random.nextDouble() * 2 * Math.PI;
            double k = Math.sqrt(random.nextDouble());
            return new double[]{x_center + (radius * Math.cos(angle) * k), y_center + (radius * Math.sin(angle) * k)};
        }
    }
}