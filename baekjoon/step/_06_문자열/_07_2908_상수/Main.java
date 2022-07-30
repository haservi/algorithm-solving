package baekjoon.step._06_문자열._07_2908_상수;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2908
 */
class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int firstNumber = br.nextInt();
        int secondNumber = br.nextInt();

        Solution solution = new Solution();
        firstNumber = solution.reverseNubmer(firstNumber);
        secondNumber = solution.reverseNubmer(secondNumber);

        int maxNumber = Math.max(firstNumber, secondNumber);
        System.out.println(maxNumber);

    }

    public static class Solution {

        private int reverseNubmer(int number) {

            int reverse = 0;

            while (number != 0) {
                int digit = number % 10;
                reverse = reverse * 10 + digit;
                number /= 10;
            }

            return reverse;
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