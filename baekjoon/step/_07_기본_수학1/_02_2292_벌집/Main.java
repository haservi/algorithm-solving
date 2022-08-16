package baekjoon.step._07_기본_수학1._02_2292_벌집;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2292
 */
class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int inputNumber = br.nextInt();
        Solution solution = new Solution();
        solution.solution(inputNumber);

    }

    public static class Solution {
        private void solution(int inputNumber) {
            // 2 -> 8 -> 20 -> 38 순으로 방이 6의 배수만큼 늘어남
            // (1) + (1 * 6) + (2 * 6) + (3 * 6)
            int nextRoomSmallNumber = 2;
            int count = 1;

            if (inputNumber == 1) {
                System.out.println(1);
            } else {
                while (nextRoomSmallNumber <= inputNumber) {
                    nextRoomSmallNumber = nextRoomSmallNumber + (6 * count);
                    count++;
                }
                System.out.println(count);
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