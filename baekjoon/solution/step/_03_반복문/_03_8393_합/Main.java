package baekjoon.solution.step._03_반복문._03_8393_합;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/8393
 */
public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();

        int count = rd.nextInt();
        
        Solution solution = new Solution();
        int result = solution.solution(count);
        System.out.println(result);
    }

    private static class Solution {

        private int solution(int n) {
            int result = 0;
            for (int i = 1; i <= n; i++) {
                result += i;
            }
            return result;
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
    }
}