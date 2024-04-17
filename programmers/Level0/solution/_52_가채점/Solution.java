package programmers.Level0.solution._52_가채점;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250128
 */
class Solution {

    public static void main(String[] args) {
        int[] numbers = { 1 };
        int[] our_score = { 100 };
        int[] score_list = { 100, 80, 90, 84, 20 };
        String[] expectedResult = { "Same" };

        Solution solution = new Solution();
        String[] result = solution.solution(numbers, our_score, score_list);

        if (Arrays.equals(result, expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(int[] numbers, int[] our_score, int[] score_list) {
        int num_student = numbers.length;
        String[] answer = new String[num_student];

        for (int i = 0; i < num_student; i++) {
            if (our_score[i] == score_list[numbers[i] - 1]) {
                answer[i] = "Same";
            } else {
                answer[i] = "Different";
            }
        }

        return answer;
    }
}
