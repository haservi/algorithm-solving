package baekjoon.solution.step._02_조건문._02_9498_시험_성적;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/9498
 */
public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();

        int a = rd.nextInt();

        Solution solution = new Solution();
        String score = solution.solution(a);
        System.out.println(score);
    }

    static class Solution {

        public String solution(int score) {
            if (90 <= score && score <= 100)
                return "A";
            else if (80 <= score && score <= 89)
                return "B";
            else if (70 <= score && score <= 79)
                return "C";
            else if (60 <= score && score <= 69)
                return "D";
            else
                return "F";

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