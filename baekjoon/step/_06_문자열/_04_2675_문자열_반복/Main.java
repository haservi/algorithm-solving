package baekjoon.step._06_문자열._04_2675_문자열_반복;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2675
 */
class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int T = br.nextInt();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < T; i++) {

            int R = br.nextInt();
            String S = br.next();

            for (int j = 0; j < S.length(); j++) {
                for (int k = 0; k < R; k++) {
                    result.append(S.charAt(j));
                }
            }
            result.append('\n');
        }
        System.out.print(result);

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