package programmers.Level1.solution._10_부족한_금액_계산하기;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/82612
 */
class Solution {

    public static void main(String[] args) {
        System.out.println("test");
        Solution solution = new Solution();
        long result = solution.solution(3, 20, 4);
        System.out.println("결과: " + result);
    }

    public long solution(int price, int money, int count) {
        long answer = 0;
        long totalPrice = 0;
        for (int i = 1; i <= count; i++) {
            totalPrice += (price * i);
        }
        answer = totalPrice - money;
        if (answer > 0) {
            return answer;
        }
        return 0;
    }

    public long solution1(long price, long money, long count) {
        return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }
}