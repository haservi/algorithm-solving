package programmers.Level0.solution._20_배열_두배_만들기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120809
 */
public class Solution {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 100, -99, 1, 2, 3 };

        Solution solution = new Solution();
        int[] result = solution.solution(numbers);
        System.out.println("result: " + Arrays.toString(result));
    }

    public int[] solution(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] *= 2;
        }
        int[] answer = numbers;
        return answer;
    }
}
