package baekjoon.step._01_입출력과_사칙연산.solution._10_10926_question;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/10926
 */
public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();

        String a = rd.nextLine();

        System.out.println(a + "??!");

    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}