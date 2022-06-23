package baekjoon.solution.step._03_반복문._02_10950_a_plus_b_minus_3;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/10950
 */
public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();

        int count = rd.nextInt();
        
        for (int i = 0; i < count; i++) {
            int a = rd.nextInt();
            int b = rd.nextInt();
            System.out.println(a + b);
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