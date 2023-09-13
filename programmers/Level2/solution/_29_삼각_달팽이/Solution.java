package programmers.Level2.solution._29_삼각_달팽이;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int n = 6;
        int[] expected = { 1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11 };

        Solution solution = new Solution();
        int[] result = solution.solution(n);

        if (Arrays.equals(result, expected)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private static final int[] DIRECTIONS_X = { 0, 1, -1 };
    private static final int[] DIRECTIONS_Y = { 1, 0, -1 };

    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int vertex = 1;
        int x = 0;
        int y = 0;
        int direction = 0;

        int fillCount = n * (n + 1) / 2;
        for (vertex = 1; vertex <= fillCount; vertex++) {
            triangle[y][x] = vertex;

            int nextX = x + DIRECTIONS_X[direction];
            int nextY = y + DIRECTIONS_Y[direction];

            if (nextX <= y && nextY < n && triangle[nextY][nextX] == 0) {
                x = nextX;
                y = nextY;
            } else {
                direction = (direction + 1) % 3;
                x += DIRECTIONS_X[direction];
                y += DIRECTIONS_Y[direction];
            }
        }

        int[] answer = new int[fillCount];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
    }

}
