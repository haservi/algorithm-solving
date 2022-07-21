package baekjoon.step._04_1차원_배열._03_2577_숫자의_개수;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2577
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int count = 3;
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = br.nextInt();
        }

        Solution solution = new Solution();
        solution.solution(numbers);

    }

    public static class Solution {
        public void solution(int[] numbers) {
            int multiplResult = 1;
            // 숫자 곱하기
            for (int number : numbers) {
                multiplResult *= number;
            }

            int[] counts = new int[10];
            while (0 < multiplResult) {
                int index = multiplResult % 10;
                counts[index]++;
                multiplResult /= 10;
            }

            // 0부터 출력
            for (int count : counts) {
                System.out.println(count);
            }

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