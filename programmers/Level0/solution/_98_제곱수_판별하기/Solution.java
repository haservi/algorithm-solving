package programmers.Level0.solution._98_제곱수_판별하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120909?language=java
 */
class Solution {

    public static void main(String[] args) {
        int n = 144;
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution(n);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int n) {
        if (Math.sqrt(n) % 1 == 0) {
            return 1;
        }
        return 2;
    }
}
