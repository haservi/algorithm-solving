package programmers.Level0.solution._111_카운트_다운;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181899?language=java
 */
class Solution {

    public static void main(String[] args) {
        int start_num = 10;
        int end_num = 3;
        int[] expectedResult = { 10, 9, 8, 7, 6, 5, 4, 3 };

        Solution solution = new Solution();
        int[] result = solution.solution(start_num, end_num);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int start_num, int end_num) {
        int[] answer = new int[start_num - end_num + 1];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = start_num - i;
        }
        return answer;
    }
}
