package baekjoon.solution.step._01_입출력과_사칙연산._13_2588_곱셈;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FastReader rd = new FastReader();

        int a = rd.nextInt();
        int b = rd.nextInt();

        Solution solution = new Solution();
        Queue<Integer> stack = solution.setSplitNumber(b);

        int sum = 0;
        int digit = 1;
        while (!stack.isEmpty()) {
            int digitMultiple = a * stack.poll();
            System.out.println(digitMultiple);
            sum += (digitMultiple * digit);
            digit *= 10;
        }
        System.out.println(sum);

    }

    public static class Solution {

        // 2번째 숫자를 한자리씩 리스트에 저장
        private Queue<Integer> setSplitNumber(int num) {

            Queue<Integer> queue = new LinkedList<>();
            while (num > 0) {
                queue.add(num % 10);
                num /= 10;
            }
            return queue;
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
    }
}