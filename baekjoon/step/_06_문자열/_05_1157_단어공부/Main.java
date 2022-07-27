package baekjoon.step._06_문자열._05_1157_단어공부;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/1157
 */
class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        String inputString = br.nextLine();
        int[] alphabetsCount = new int[26];

        // 대문자로 변경
        inputString = inputString.toUpperCase();
        for (int i = 0; i < inputString.length(); i++) {
            int alphabetIndex = inputString.charAt(i) - 'A';
            // 알파벳의 인덱스값에 맞게 카운팅
            alphabetsCount[alphabetIndex]++;
        }

        // int maxCount = Arrays.stream(alphabetsCount).max().getAsInt(); // 중복 찾기가 필요
        int maxCount = -1;
        char resultChar = '?';
        for (int i = 0; i < alphabetsCount.length; i++) {

            if (maxCount < alphabetsCount[i]) {
                maxCount = alphabetsCount[i];
                resultChar = (char) (i + 'A');

            } else if (maxCount == alphabetsCount[i]) {
                resultChar = '?';
            }
        }

        // System.out.println(Arrays.toString(alphabetsCount));
        System.out.println(resultChar);

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