package baekjoon.step._03_반복문._15_25304_영수증;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/25304
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader br = new FastReader();

        int totalPrice = br.nextInt();
        int totalItemCount = br.nextInt();

        List<Item> itemList = new ArrayList<>();

        for (int i = 0; i < totalItemCount; i++) {
            String[] input = br.nextLine().split(" ");
            int price = Integer.parseInt(input[0]);
            int count = Integer.parseInt(input[1]);
            itemList.add(new Item(price, count));
        }

        int sumResult = itemList.stream().mapToInt(item -> (item.price * item.count)).sum();

        if (totalPrice == sumResult) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }

    }

    public static class Item {
        private final int price;
        private final int count;

        public Item(int price, int count) {
            this.price = price;
            this.count = count;
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