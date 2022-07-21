package baekjoon.step._02_조건문._05_2884_알람_시계;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2884
 */
public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();

        int hour = rd.nextInt();
        int minute = rd.nextInt();

        Solution solution = new Solution();
        String result = solution.solution(hour, minute);
        System.out.println(result);
    }

    private static class Solution {

        private String solution(int hour, int minute) {

            int minuteDiff = minute - 45;
            // 분이 음수인 경우
            if (minuteDiff < 0) {
                hour--;
                minuteDiff += 60;
                // 시간이 음수인 경우
                if (hour < 0) {
                    hour += 24;
                }
            }
            return hour + " " + minuteDiff;
        }

    }

    static class FastReader {
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