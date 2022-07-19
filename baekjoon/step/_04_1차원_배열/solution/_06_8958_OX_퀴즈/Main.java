package baekjoon.step._04_1차원_배열.solution._06_8958_OX_퀴즈;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/8958
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int count = br.nextInt();
        String[] quizzes = new String[count];

        for (int i = 0; i < count; i++) {
            quizzes[i] = br.nextLine();
        }

        Solution solution = new Solution();
        solution.solution(quizzes);

    }

    public static class Solution {
        public void solution(String[] quizzes) {

            for (String quiz : quizzes) {
                int totalScore = 0;
                char[] quizSplit = quiz.toCharArray();
                int score = 0;
                for (char quizChar : quizSplit) {
                    if (quizChar == 'O') {
                        score++;
                        totalScore += score;
                    } else {
                        score = 0;
                    }
                }
                System.out.println(totalScore);
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