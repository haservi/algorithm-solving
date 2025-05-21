package programmers.Level0.solution._154_2차원으로_만들기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120842?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] num_list = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = 2;
        int[][] expectedResult = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };

        Solution solution = new Solution();
        int[][] result = solution.solution(num_list, n);

        if (Arrays.deepEquals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        for (int i = 0; i < num_list.length; i++) {
            int index = i % n;
            int index2 = i / n;
            answer[index2][index] = num_list[i];
        }
        return answer;
    }
}
