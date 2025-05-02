package programmers.Level0.solution._149_최댓값_만들기_2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120862?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, -3, 4, -5 };
        int expectedResults = 15;

        Solution solution = new Solution();
        int result = solution.solution(numbers);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] numbers) {

        Arrays.sort(numbers);

        // 가장 작은 두 수의 곱
        int firstCase = numbers[0] * numbers[1];
        // 가장 큰 두 수의 곱
        int lastCase = numbers[numbers.length - 1] * numbers[numbers.length - 2];

        return Math.max(firstCase, lastCase);
    }
}
