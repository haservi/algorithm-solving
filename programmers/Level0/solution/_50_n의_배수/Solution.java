package programmers.Level0.solution._50_n의_배수;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181937
 */
public class Solution {
    public static void main(String[] args) {
        int num = 98;
        int n = 2;
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution(num, n);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int num, int n) {
        return (num % n) == 0 ? 1 : 0;
    }
}
