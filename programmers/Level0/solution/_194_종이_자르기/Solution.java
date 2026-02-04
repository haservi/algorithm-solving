package programmers.Level0.solution._194_종이_자르기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120922?language=java
 */
class Solution {

    public static void main(String[] args) {
        int M = 2;
        int N = 2;
        int expectedResult = 3;

        Solution solution = new Solution();
        int result = solution.solution(M, N);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int M, int N) {
        return M * N - 1;
    }

}
