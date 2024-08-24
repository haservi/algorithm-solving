package programmers.Level0.solution._80_정수를_나선형으로_배치하기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181832?language=java
 */
class Solution {

    public static void main(String[] args) {
        int n = 5;
        int[][] expectedResult = {
            {1, 2, 3, 4, 5},
            {16, 17, 18, 19, 6},
            {15, 24, 25, 20, 7},
            {14, 23, 22, 21, 8},
            {13, 12, 11, 10, 9}
        };

        Solution solution = new Solution();
        int[][] result = solution.solution(n);
        if (Arrays.deepEquals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int x = 0;
        int y = 0;
        int dir = 0;
        for (int i = 1; i <= n * n; i++) {
            answer[x][y] = i;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] != 0) {
                // 방향을 시계방향으로 전환
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        return answer;
    }
}
