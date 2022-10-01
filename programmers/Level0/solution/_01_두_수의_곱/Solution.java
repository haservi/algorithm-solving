package programmers.Level0.solution._01_두_수의_곱;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120804
 */
public class Solution {

    public static void main(String[] args) {

        int num1 = 4;
        int num2 = 5;

        Solution solution = new Solution();
        int result = solution.solution(num1, num2);
        System.out.println("result: " + result);

    }

    public int solution(int num1, int num2) {
        int answer = num1 * num2;
        return answer;
    }
}
