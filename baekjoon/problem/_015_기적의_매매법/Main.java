package baekjoon.problem._015_기적의_매매법;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20546
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 100
        int cash = Integer.parseInt(br.readLine());

        // 10 20 23 34 55 30 22 19 12 45 23 44 34 38
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] stockPrices = new int[14];
        for (int i = 0; i < stockPrices.length; i++) {
            stockPrices[i] = Integer.parseInt(st.nextToken());
        }

        String result = solution(cash, stockPrices);
        System.out.println(result);
    }

    static class User {
        int cash;
        int stockCount;

        User(int cash) {
            this.cash = cash;
            this.stockCount = 0;
        }

        void buyStock(int price) {
            int count = this.cash / price;
            this.stockCount += count;
            this.cash -= count * price;
        }

        void sellStock(int price) {
            this.cash += this.stockCount * price;
            this.stockCount = 0;
        }

        int totalValue(int stockPrice) {
            return this.cash + (this.stockCount * stockPrice);
        }
    }

    public static String solution(int cash, int[] stockPrices) {
        User seongmin = new User(cash);
        User junhyeon = new User(cash);

        // 준현이의 매매 패턴: 무조건 매수
        for (int price : stockPrices) {
            if (junhyeon.cash >= price) {
                junhyeon.buyStock(price);
            }
        }

        // 성민이의 매매 패턴: 3일 연속 상승/하락에 따른 매매
        for (int i = 3; i < stockPrices.length; i++) {
            if (isIncreasing(stockPrices, i)) {
                seongmin.sellStock(stockPrices[i]);
            } else if (isDecreasing(stockPrices, i) && seongmin.cash >= stockPrices[i]) {
                seongmin.buyStock(stockPrices[i]);
            }
        }

        int seongminTotal = seongmin.totalValue(stockPrices[stockPrices.length - 1]);
        int junhyeonTotal = junhyeon.totalValue(stockPrices[stockPrices.length - 1]);

        if (seongminTotal > junhyeonTotal) {
            return "TIMING";
        } else if (seongminTotal < junhyeonTotal) {
            return "BNP";
        } else {
            return "SAMESAME";
        }
    }

    private static boolean isIncreasing(int[] prices, int index) {
        return prices[index - 3] < prices[index - 2]
                && prices[index - 2] < prices[index - 1]
                && prices[index - 1] < prices[index];
    }

    private static boolean isDecreasing(int[] prices, int index) {
        return prices[index - 3] > prices[index - 2]
                && prices[index - 2] > prices[index - 1]
                && prices[index - 1] > prices[index];
    }
}
