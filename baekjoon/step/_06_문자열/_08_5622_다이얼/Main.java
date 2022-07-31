package baekjoon.step._06_문자열._08_5622_다이얼;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/5622
 */
class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        String dialString = br.nextLine();

        Solution solution = new Solution();
        int sum = 0;

        for (int i = 0; i < dialString.length(); i++) {
            sum += solution.dialConvertNumber(dialString.charAt(i));
            sum += 1; // 다이얼을 돌리는데 걸리는 시간
        }

        System.out.println(sum);

    }

    public static class Solution {
        /**
         * 다이얼의 문자 규칙이 불규칙하여 각각 정의가 필요
         * 
         * @param dialChar dialChar
         * @return
         */
        private int dialConvertNumber(char dialChar) {

            int number = 0;

            switch (dialChar) {
                case 'A':
                case 'B':
                case 'C':
                    number = 2;
                    break;
                case 'D':
                case 'E':
                case 'F':
                    number = 3;
                    break;
                case 'G':
                case 'H':
                case 'I':
                    number = 4;
                    break;
                case 'J':
                case 'K':
                case 'L':
                    number = 5;
                    break;
                case 'M':
                case 'N':
                case 'O':
                    number = 6;
                    break;
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                    number = 7;
                    break;
                case 'T':
                case 'U':
                case 'V':
                    number = 8;
                    break;
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    number = 9;
                    break;
            }

            return number;
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