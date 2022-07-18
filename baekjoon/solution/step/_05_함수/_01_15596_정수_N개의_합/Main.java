package baekjoon.solution.step._05_함수._01_15596_정수_N개의_합;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/15596
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int size = br.nextInt();
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = br.nextInt();
        }

        Test solution = new Test();
        long result = solution.sum(a);
        System.out.println(result);

    }

    /**
     * 해당 문제는 아래의 클래스 자체가 정답임
     */
    public static class Test {

        private long sum(int[] a) {

            long result = 0;
            for (int number : a) {
                result += number;
            }

            return result;
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