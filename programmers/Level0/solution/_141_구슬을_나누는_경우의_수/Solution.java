package programmers.Level0.solution._141_구슬을_나누는_경우의_수;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120840?language=java
 */
class Solution {

    public static void main(String[] args) {
        int balls = 3;
        int share = 2;
        int expectedResults = 3;

        Solution solution = new Solution();
        int result = solution.solution(balls, share);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int balls, int share) {
        return factorial(balls, share);
    }

    public static int factorial(int balls, int share) {
        if (balls == share || share == 0) {
            return 1;
        }
        return factorial((balls - 1), (share - 1)) + factorial(balls - 1, share);
    }
}
