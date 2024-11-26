package programmers.Level0.solution._106_정사각형으로_만들기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181830?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[][] arr = {
                { 572, 22, 37 },
                { 287, 726, 384 },
                { 85, 137, 292 },
                { 487, 13, 876 }
        };
        int[][] expectedResult = {
                { 572, 22, 37, 0 },
                { 287, 726, 384, 0 },
                { 85, 137, 292, 0 },
                { 487, 13, 876, 0 }
        };

        Solution solution = new Solution();
        int[][] result = solution.solution(arr);

        if (Arrays.deepEquals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[][] solution(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int max = Math.max(rows, cols);

        int[][] answer = new int[max][max];
        // 기존 배열의 값을 복사
        for (int i = 0; i < rows; i++) {
            System.arraycopy(arr[i], 0, answer[i], 0, cols);
        }

        return answer;
    }

}
