package programmers.Level0.solution._153_공_던지기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120843?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4 };
        int k = 2;
        int expectedResults = 3;

        Solution solution = new Solution();
        int result = solution.solution(numbers, k);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] numbers, int k) {
        int moveCount = k - 1;
        int targetIndex = (moveCount * 2) % numbers.length;
        return numbers[targetIndex];
    }
}
