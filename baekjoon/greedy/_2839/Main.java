package baekjoon.greedy._2839;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * https://www.acmicpc.net/problem/2839
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FastReader rd = new FastReader();
        int N = rd.nextInt();

        if (N == 4 || N == 7)
            System.out.println(-1);
        else if (N % 5 == 0)
            System.out.println(N / 5);
        else if (N % 5 == 1 || N % 5 == 3)
            System.out.println((N / 5) + 1);
        else if (N % 5 == 2 || N % 5 == 4)
            System.out.println((N / 5) + 2);
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