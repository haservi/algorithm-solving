package baekjoon.step._06_문자열._09_2941_크로아티아_알파벳;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2941
 */
class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        String inputString = br.nextLine();
        String[] kroatiaWords = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

        for (int i = 0; i < kroatiaWords.length; i++) {
            if (inputString.contains(kroatiaWords[i])) {
                inputString = inputString.replace(kroatiaWords[i], "_");
                // System.out.println("input change: " + inputString);
            }
        }

        System.out.println(inputString.length());

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