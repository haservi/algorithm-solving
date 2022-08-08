package baekjoon.step._01_입출력과_사칙연산._15_킹퀸룩비숍나이트폰;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/3003
 */
public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();

        int[] answer = { 1, 1, 2, 2, 2, 8 };
        int[] input = new int[6];
        for (int i = 0; i < input.length; i++) {
            input[i] = rd.nextInt();
        }

        int[] result = new int[6];
        for (int i = 0; i < answer.length; i++) {
            result[i] = answer[i] - input[i];
            System.out.print(result[i] + " ");
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