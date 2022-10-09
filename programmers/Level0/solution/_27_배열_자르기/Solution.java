package programmers.Level0.solution._27_배열_자르기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120833
 */
public class Solution {

    public static void main(String[] args) {
        int[] numbers = { 4, 5, 6, 6, 7 };
        int num1 = 2;
        int num2 = 3;

        Solution solution = new Solution();
        int[] result = solution.solution(numbers, num1, num2);
        System.out.println("result: " + Arrays.toString(result));

    }

    public int[] solution(int[] numbers, int num1, int num2) {
        int count = num2 - num1 + 1;
        int[] answer = new int[count];
        for (int i = 0; i < count; i++) {
            answer[i] = numbers[num1];
            num1++;
        }
        return answer;
    }

    public int[] diffSolution(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }
}
