package programmers.Level0.solution._193_연속된_수의_합;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120923?language=java
 */
class Solution {

    public static void main(String[] args) {
        int num = 3;
        int total = 12;
        int[] expectedResult = {3, 4, 5};

        Solution solution = new Solution();
        int[] result = solution.solution(num, total);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int num, int total) {
        int[] answer = new int[num];

        int start = (total / num) - (num - 1) / 2;

        for (int i = 0; i < num; i++) {
            answer[i] = start + i;
        }

        return answer;
    }
}
