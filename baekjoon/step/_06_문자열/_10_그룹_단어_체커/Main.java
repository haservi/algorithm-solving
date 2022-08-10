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
            if (isGroupNumber(br.next())) {
                result++;
            }
        }
        System.out.println(result);

    }

    /**
     * Group Number Check
     * 
     * @param input
     * @return
     */
    public static boolean isGroupNumber(String input) {

        boolean[] checked = new boolean[26];
        int prev = 0;
        for (int j = 0; j < input.length(); j++) {
            int now = input.charAt(j);
            // 이전 알파벳과 10진수 비교
            if (prev != now) {
                // 중복 여부 확인
                if (checked[now - 'a'] == false) {
                    checked[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }

            } else { // 10진수 같은 경우 계속 진행
                continue;
            }
        }

        return true;
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