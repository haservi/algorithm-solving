package programmers.Level0.solution._21_세균_증식;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120910
 */
public class Solution {

    public static void main(String[] args) {
        int n = 7;
        int t = 15;

        Solution solution = new Solution();
        int result = solution.solution(n, t);
        System.out.println("result: " + result);
    }

    public int solution(int n, int t) {
        int count = 0;
        while (count != t) {
            n *= 2;
            count++;
        }
        int answer = n;
        return answer;
    }
}
