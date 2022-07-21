package baekjoon.step._01_입출력과_사칙연산._05_1000_a_plus_b;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/1000
 */
public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();

        int a = rd.nextInt();
        int b = rd.nextInt();
        System.out.println(a + b);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}