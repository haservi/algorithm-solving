package programmers.Level1.solution._76_지폐_접기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/340199?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[] wallet = { 50, 50 };
        int[] bill = { 100, 241 };
        int expectedResult = 4;

        Solution solution = new Solution();
        int result = solution.solution(wallet, bill);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int billWidth = bill[0];
        int billHeight = bill[1];
        int walletMin = Math.min(wallet[0], wallet[1]);
        int walletMax = Math.max(wallet[0], wallet[1]);
        while (true) {

            // 지폐의 최소, 최대 길이
            int billMin = Math.min(billWidth, billHeight);
            int billMax = Math.max(billWidth, billHeight);

            // 지폐가 지갑에 들어갈 수 있는지 확인
            if (billMax <= walletMax && billMin <= walletMin) {
                break;
            }

            // 들어갈 수 없다면 지폐의 큰 쪽을 접음
            if (billWidth > billHeight) {
                billWidth /= 2;
            } else {
                billHeight /= 2;
            }

            answer++;
        }
        return answer;
    }

    public int solution1(int[] wallet, int[] bill) {
        int answer = 0;
        int walletWidth = wallet[0];
        int walletHeight = wallet[1];
        int billWidth = bill[0];
        int billHeight = bill[1];

        while (true) {
            // 지갑의 최소, 최대 길이
            int walletMin = Math.min(walletWidth, walletHeight);
            int walletMax = Math.max(walletWidth, walletHeight);
            // 지폐의 최소, 최대 길이
            int billMin = Math.min(billWidth, billHeight);
            int billMax = Math.max(billWidth, billHeight);

            // 지폐가 지갑에 들어갈 수 있는지 확인
            if (billMax <= walletMax && billMin <= walletMin) {
                break;
            }

            // 들어갈 수 없다면 지폐의 큰 쪽을 접음
            if (billWidth > billHeight) {
                billWidth /= 2;
            } else {
                billHeight /= 2;
            }

            answer++;
        }

        return answer;
    }

}
