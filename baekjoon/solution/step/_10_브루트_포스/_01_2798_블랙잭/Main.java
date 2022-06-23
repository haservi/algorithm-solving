package baekjoon.solution.step._10_브루트_포스._01_2798_블랙잭;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2798
 */
public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();

        int a = rd.nextInt();

        Solution solution = new Solution();
        int result = solution.solution();
        System.out.println(result);
    }

    public static class Solution {

        private int solution() {

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