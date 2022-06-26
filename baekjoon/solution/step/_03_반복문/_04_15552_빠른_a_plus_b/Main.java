package baekjoon.solution.step._03_반복문._04_15552_빠른_a_plus_b;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/15552
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = br.nextInt();

        for (int i = 0; i < count; i++) {
            bw.write((Integer.parseInt(br.next()) + Integer.parseInt(br.next())) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

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