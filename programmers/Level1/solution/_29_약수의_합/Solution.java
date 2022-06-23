package programmers.Level1.solution._29_약수의_합;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12928
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 1000;

        int result = solution.solution(n);
        System.out.println("결과 : " + result);
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }
}
