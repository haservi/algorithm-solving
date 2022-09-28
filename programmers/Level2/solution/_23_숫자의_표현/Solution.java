package programmers.Level2.solution._23_숫자의_표현;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12924
 */
public class Solution {

    public static void main(String[] args) {

        int n = 15;

        Solution solution = new Solution();
        int result = solution.solution(n);

        System.out.println("result: " + result);
    }

    public int solution(int n) {

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                }
                if (n <= sum) {
                    break;
                }
            }
        }
        return answer;

    }

}
