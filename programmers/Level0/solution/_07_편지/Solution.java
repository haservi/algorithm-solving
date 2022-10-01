package programmers.Level0.solution._07_편지;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120898
 */
public class Solution {
    
    public static void main(String[] args) {
        
        String message = "happy birthday!";

        Solution solution = new Solution();
        int result = solution.solution(message);
        System.out.println("result: " + result);
    }

    public int solution(String message) {
        int answer = message.length() * 2;
        return answer;
    }
}
