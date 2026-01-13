package programmers.Level0.solution._190_특별한_이차원_배열_1;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181833?language=java
 */
class Solution {

    public static void main(String[] args) {
        int n = 3;
        int[][] expectedResult = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        Solution solution = new Solution();
        int[][] result = solution.solution(n);

        if (Arrays.deepEquals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        for (int i = 0; i < n; i++) {
            answer[i][i] = 1;
        }

        return answer;
    }
}
