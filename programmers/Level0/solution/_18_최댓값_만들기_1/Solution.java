package programmers.Level0.solution._18_최댓값_만들기_1;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120847
 */
public class Solution {

    public static void main(String[] args) {
        int[] numbers = { 1, 5, 2, 4 };

        Solution solution = new Solution();
        int result = solution.solution(numbers);
        System.out.println("result: " + result);
    }

    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int answer = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        return answer;
    }
}
