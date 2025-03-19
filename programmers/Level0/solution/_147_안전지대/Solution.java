package programmers.Level0.solution._147_안전지대;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120866?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[][] board = {
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0 }
        };
        int expectedResults = 16;

        Solution solution = new Solution();
        int result = solution.solution(board);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        boolean[][] bombMap = new boolean[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    markBombArea(bombMap, i, j, n);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!bombMap[i][j]) {
                    answer += 1;
                }
            }
        }
        return answer;
    }

    private static final int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static final int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    private void markBombArea(boolean[][] bombMap, int x, int y, int n) {
        bombMap[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                bombMap[nx][ny] = true;
            }
        }
    }
}
