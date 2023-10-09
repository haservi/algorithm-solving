package programmers.Level2.solution._33_행렬의_곱셈;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[][] arr1 = { { 2, 3, 2 }, { 4, 2, 4 }, { 3, 1, 4 } };
        int[][] arr2 = { { 5, 4, 3 }, { 2, 4, 1 }, { 3, 1, 1 } };
        int[][] expected = { { 22, 22, 11 }, { 36, 28, 18 }, { 29, 20, 14 } };

        Solution solution = new Solution();
        int[][] result = solution.solution(arr1, arr2);
        if (Arrays.deepEquals(result, expected)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                answer[i][j] += calculateMatrixElement(arr1[i], arr2, j);
            }
        }
        return answer;
    }

    private int calculateMatrixElement(int[] row, int[][] matrix, int colIndex) {
        int sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i] * matrix[i][colIndex];
        }
        return sum;
    }

}
