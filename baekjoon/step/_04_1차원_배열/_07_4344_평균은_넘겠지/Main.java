package baekjoon.step._04_1차원_배열._07_4344_평균은_넘겠지;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/4344
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        // 테스트 케이스
        int testCase = br.nextInt();
        for (int i = 0; i < testCase; i++) {
            // 학생의 수
            int person = br.nextInt();
            int[] scores = new int[person];
            double sum = 0;

            // 학생별 점수 저장 및 총합 저장
            for (int j = 0; j < person; j++) {
                scores[j] = br.nextInt();
                sum += scores[j];
            }

            double average = sum / person;
            double averageUpCount = 0;
            for (int score : scores) {
                if (average < score) {
                    averageUpCount++;
                }
            }
            double standardAverage = (averageUpCount / person) * 100;
            System.out.printf("%.3f%%\n", standardAverage);
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