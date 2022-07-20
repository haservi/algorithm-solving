package baekjoon.step._05_함수.solution._03_1065_한수;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/1065
 */
class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int n = br.nextInt();
        int result = hansooCount(n);
        System.out.println(result);

    }

    private static int hansooCount(int n) {

        // 2자리수 이하는 모두 공차를 가진 등차수열
        if (n < 100) {
            return n;
        }
        // 3자리수는 99개의 한수를 지니고 있음
        int count = 99;

        for (int i = 100; i <= n; i++) {
            int three = i / 100;
            int two = (i / 10) % 10;
            int one = i % 10;

            if ((three - two) == (two - one)) {
                count++;
                // System.out.println(i);
            }
        }
        return count;
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