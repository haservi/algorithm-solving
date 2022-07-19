package baekjoon.step._03_반복문.solution._14_1110_더하기_사이클;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/1110
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int number = br.nextInt();

        Solution solution = new Solution();
        int result = solution.solution(number);
        System.out.println(result);

    }

    public static class Solution {

        private int solution(int number) {

            int tempNumber = number;
            int matchNumber = 0;
            int cycle = 0;
            int a = 0;
            int b = 0;

            while (true) {
                if (cycle == 0) {
                    a = tempNumber / 10;
                    b = tempNumber % 10;
                } else {
                    a = b;
                    b = tempNumber % 10;
                }

                tempNumber = a + b;
                matchNumber = (b * 10) + (tempNumber % 10);

                cycle++;
                if (number == matchNumber) {
                    break;
                }
            }

            return cycle;
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