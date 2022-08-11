package baekjoon.step._07_기본_수학1._01_1712_손익분기점;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/1712
 */
class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int A = br.nextInt();
        int B = br.nextInt();
        int C = br.nextInt();

        Solution solution = new Solution();
        int result = solution.solution(A, B, C);
        System.out.println(result);

    }

    public static class Solution {

        private int solution(int A, int B, int C) {
            // 판매가격보다 제조비가 크거가 같으면 손해
            if (B >= C)
                return -1;

            // (원금 / 이익금) => 원금회수 횟수 + 1 => 이익발생
            return ((A / (C - B)) + 1);
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