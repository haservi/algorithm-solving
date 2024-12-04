package programmers.Level0.solution._110_배열_만들기_1;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181901?language=java
 */
class Solution {

    public static void main(String[] args) {
        int n = 10;
        int k = 3;
        int[] expectedResult = { 3, 6, 9 };

        Solution solution = new Solution();
        int[] result = solution.solution(n, k);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int n, int k) {
        int[] answer = new int[n / k];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = k * (i + 1);
        }
        return answer;
    }

}
