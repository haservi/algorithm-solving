package baekjoon.step._03_반복문._01_2739_구구단;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2739
 */
public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();

        int num = rd.nextInt();

        Solution solution = new Solution();
        solution.solution(num);
    }

    private static class Solution {

        private void solution(int num) {
            for (int i = 1; i <= 9; i++) {
                System.out.println(num + " * " + i + " = " + (num * i));
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