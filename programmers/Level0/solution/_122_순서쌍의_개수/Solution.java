package programmers.Level0.solution._122_순서쌍의_개수;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120836?language=java
 */
class Solution {

    public static void main(String[] args) {
        int n = 20;
        int expectedResult = 6;

        Solution solution = new Solution();
        int result = solution.solution(n);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                answer++;
                if (n / i != i) {
                    answer++;
                }
            }
        }
        return answer;
    }

}
