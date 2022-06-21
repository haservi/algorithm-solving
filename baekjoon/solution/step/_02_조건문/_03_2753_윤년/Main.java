package baekjoon.solution.step._02_조건문._03_2753_윤년;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2753
 */
public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();

        int a = rd.nextInt();

        Solution solution = new Solution();
        int result = solution.solution(a);
        System.out.println(result);
    }

    static class Solution {

        private int solution(int year) {

            if (year % 4 == 0)
                if (year % 400 == 0)
                    return 1;
                else if (year % 100 != 0)
                    return 1;
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