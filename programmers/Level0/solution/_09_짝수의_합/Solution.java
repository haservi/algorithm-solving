package programmers.Level0.solution._09_짝수의_합;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120831
 */
public class Solution {

    public static void main(String[] args) {
        int n = 10;

        Solution solution = new Solution();
        int result = solution.solution(n);
        System.out.println("result: " + result);
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i += 2) {
            answer += i;
        }
        return answer;
    }
    
}
