package baekjoon.step._03_반복문._06_2742_기찍_N;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2742
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int number = br.nextInt();
        br.close();

        for (int i = number; i >= 1; i--) {
            System.out.println(i);
        }

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

        void close() throws IOException {
            br.close();
        }
    }
}