package baekjoon.step._06_문자열._10_그룹_단어_체커;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/1316
 */
class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int result = 0;
        int inputCount = br.nextInt();

        for (int i = 0; i < inputCount; i++) {
            String input = br.nextLine();
            boolean[] checked = new boolean[26];
            boolean passed = false;
            for (int j = 0; j < input.length(); j++) {
                // 처음은 무조건 통과
                if (j == 0) {
                    checked[input.charAt(j) - 'a'] = true;
                    passed = true;
                    continue;
                }
                // 중복되는 알파벳은 통과 처리
                if (input.charAt(j - 1) == input.charAt(j))
                    continue;

                // 이미 체크된 알파벳이 있는 경우 탈락
                if (checked[input.charAt(j) - 'a']) {
                    passed = false;
                    break;
                }
            }
            // 통과 여부에 따라 카운팅
            if (passed)
                result++;
        }
        System.out.println(result);

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