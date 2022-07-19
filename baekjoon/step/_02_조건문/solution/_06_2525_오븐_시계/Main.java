package baekjoon.step._02_조건문.solution._06_2525_오븐_시계;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2525
 */
public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();

        int hour = rd.nextInt();
        int minute = rd.nextInt();
        int cookingTimeMinute = rd.nextInt();

        Solution solution = new Solution();
        String result = solution.solution(hour, minute, cookingTimeMinute);
        System.out.println(result);
    }

    private static class Solution {

        private static int HOUR_MINUTE = 60;
        private static int DAY_HOUR = 24;

        private String solution(int hour, int minute, int cookingTimeMinute) {

            minute += cookingTimeMinute;
            // 60분을 초과한 경우 시간 변경
            if (minute >= HOUR_MINUTE) {
                hour += (minute / HOUR_MINUTE);
                minute %= HOUR_MINUTE;

                if (hour >= DAY_HOUR) {
                    hour -= DAY_HOUR;
                }

            }

            return hour + " " + minute;

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