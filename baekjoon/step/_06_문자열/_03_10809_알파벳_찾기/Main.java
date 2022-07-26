package baekjoon.step._06_문자열._03_10809_알파벳_찾기;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/10809
 */
class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        String word = br.nextLine();

        int[] alphabets = new int[26];
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = -1;
        }

        for (int i = 0; i < word.length(); i++) {

            // 소문자만 들어옴
            char wordChar = word.charAt(i);

            if (alphabets[wordChar - 'a'] == -1) {
                alphabets[wordChar - 'a'] = i;
            }
        }

        for (int value : alphabets) {
            System.out.print(value + " ");
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

        void close() throws IOException {
            br.close();
        }
    }
}