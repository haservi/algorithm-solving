package baekjoon.step._06_문자열._02_11720_숫자의_합;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/11720
 */
class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int numberLength = br.nextInt();
        int[] numbers = new int[numberLength];

        for (int i = 0; i < numberLength; i++) {
            numbers[i] = br.nextInt();
        }

        int result = 0;
        for (int number : numbers) {
            result += number;
        }

        System.out.println(result);

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