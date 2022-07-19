package baekjoon.step._03_반복문.solution._11_10871_x보다_작은_수;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/10871
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int count = br.nextInt();
        int maxNumber = br.nextInt();
        int[] numberArray = new int[count];

        for (int i = 0; i < count; i++) {
            numberArray[i] = br.nextInt();
        }

        br.close();

        for (int i = 0; i < count; i++) {
            if (numberArray[i] < maxNumber) {
                System.out.print(numberArray[i] + " ");
            }
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