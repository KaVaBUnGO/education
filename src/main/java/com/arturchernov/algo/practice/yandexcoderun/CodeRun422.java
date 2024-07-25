package com.arturchernov.algo.practice.yandexcoderun;

import java.io.*;

/**
 * @author Arthur Chernov
 */
public class CodeRun422 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());

        solver(b, n, writer, a);

        reader.close();
        writer.close();
    }

    private static void solver(int b, int n, BufferedWriter writer, int a) throws IOException {
        int k = b % n == 0 ? b / n : b / n + 1;
        writer.write(a > k ? "YES" : "NO");
    }
}
