package programmers.Level0.solution._04_두_수의_나눗셈;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120806
 */
public class Solution {
    
    public static void main(String[] args) {
        
        int num1 = 3;
        int num2 = 2;

        Solution solution = new Solution();
        int result = solution.solution(num1, num2);
        System.out.println("result: " + result);
    }

    public int solution(int num1, int num2) {
        int answer = (int) ((double) num1 / num2 * 1000);
        return answer;
    }
}
