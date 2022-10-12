package programmers.Level0.solution._29_피자_나눠_먹기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120814
 */
public class Solution {
    public static void main(String[] args) {
        int n = 7;

        Solution solution = new Solution();
        int result = solution.solution(n);
        System.out.println("result: " + result);
    }

    public int solution(int n) {
        return (n + 6) / 7;
    }
}
