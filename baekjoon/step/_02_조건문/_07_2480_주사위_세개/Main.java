package baekjoon.step._02_조건문._07_2480_주사위_세개;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2480
 */
public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();

        int one = rd.nextInt();
        int two = rd.nextInt();
        int three = rd.nextInt();

        Solution solution = new Solution();
        int result = solution.solution(one, two, three);
        System.out.println(result);
    }

    private static class Solution {

        private int solution(int one, int two, int three) {

            // 세개의 주사위와가 모두 같은 경우
            if (one == two && two == three && one == three) {
                return 10000 + (one * 1000);
            } else if (one == two || one == three) {
                return 1000 + (one * 100);
            } else if (two == three) {
                return 1000 + (two * 100);
            } else {
                return Math.max(one, Math.max(two, three)) * 100;
            }

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