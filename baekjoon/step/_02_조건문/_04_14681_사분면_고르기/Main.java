package baekjoon.step._02_조건문._04_14681_사분면_고르기;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/14681
 */
public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();

        int x = rd.nextInt();
        int y = rd.nextInt();

        Solution solution = new Solution();
        int result = solution.solution(x, y);
        System.out.println(result);
    }

    private static class Solution {

        private int solution(int x, int y) {
            // 1: + +, 2: - +, 3: - -, 4: + -
            if (0 < x && 0 < y)
                return 1;
            if (0 > x && 0 < y)
                return 2;
            if (0 > x && 0 > y)
                return 3;
            if (0 < x && 0 > y)
                return 4;
            return 0;
        }

    }

    static class FastReader {
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
    }
}