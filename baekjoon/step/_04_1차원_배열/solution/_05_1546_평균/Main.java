package baekjoon.step._04_1차원_배열.solution._05_1546_평균;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/1546
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int count = br.nextInt();
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = br.nextInt();
        }

        Solution solution = new Solution();
        solution.solution(numbers);

    }

    public static class Solution {
        public void solution(int[] scores) {

            Arrays.sort(scores);

            // 최대 점수
            int maxScore = scores[scores.length - 1];
            float sumScore = 0;

            for (int score : scores) {
                sumScore += convertScore(score, maxScore);
            }

            double result = sumScore / (scores.length);
            System.out.println(result);
        }

        private double convertScore(double score, double maxScore) {
            // System.out.println((float) (score / maxScore) * 100);
            return (double) (score / maxScore) * 100;
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