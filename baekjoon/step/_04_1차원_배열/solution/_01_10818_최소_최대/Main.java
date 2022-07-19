package baekjoon.step._04_1차원_배열.solution._01_10818_최소_최대;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/10818
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
        String result = solution.solution(count, numbers);
        // String result = solution.solution2(numbers);
        System.out.println(result);

    }

    public static class Solution {
        public String solution(int count, int[] numbers) {

            int min = 1000000;
            int max = -1000000;

            for (int i = 0; i < count; i++) {
                int temp = numbers[i];

                if (max < temp) {
                    max = temp;
                }
                if (temp < min) {
                    min = temp;
                }

            }
            String result = min + " " + max;
            return result;
        }

        /**
         * java.util 함수를 이용하여 해결할 수도 있다.
         * 
         * @param numbers 숫자 배열
         * @return 결과값
         */
        public String solution2(int[] numbers) {
            Arrays.sort(numbers);
            return numbers[0] + " " + numbers[numbers.length - 1];
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