package baekjoon.step._07_기본_수학1._03_1193_분수찾기;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/1193
 */
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int X = br.nextInt();
        Solution solution = new Solution();
        solution.solution(X);

    }

    public static class Solution {

        public void solution(int X) {

            int prevCountSum = 0;
            int crossCount = 1; // 대각선 개수
            while (true) {
                // 해당 대각선 범위 검색
                if (X <= (prevCountSum + crossCount)) {
                    // 홀수이면 위쪽, 홀수이면 아래쪽으로 진행
                    if (crossCount % 2 == 1) {
                        System.out.println((crossCount - (X - prevCountSum - 1)) + "/" + (X - prevCountSum));
                        break;
                    } else {
                        System.out.println((X - prevCountSum) + "/" + (crossCount - (X - prevCountSum - 1)));
                        break;
                    }
                } else {
                    prevCountSum += crossCount;
                    crossCount++;
                }
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
