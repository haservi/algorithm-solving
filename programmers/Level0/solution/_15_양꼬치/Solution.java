package programmers.Level0.solution._15_양꼬치;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120830
 */
public class Solution {

    public static void main(String[] args) {
        int n = 64;
        int k = 6;

        Solution solution = new Solution();
        int result = solution.solution(n, k);
        System.out.println("result: " + result);
    }

    public int solution(int n, int k) {

        int foodPrice = n * 12000;
        int drinkPrice = k * 2000;

        int serviceCount = n / 10;
        int servicePrice = serviceCount * 2000;

        int answer = foodPrice + drinkPrice - servicePrice;

        return answer;
    }

}
