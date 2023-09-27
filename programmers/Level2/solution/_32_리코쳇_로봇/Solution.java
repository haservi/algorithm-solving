package programmers.Level2.solution._32_리코쳇_로봇;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        String[] board = { "...D..R", ".D.G...", "....D.D", "D....D.", "..D...." };
        int expected = 7;

        Solution solution = new Solution();
        int result = solution.solution(board);
        if (result == expected) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private static final int[] DIRECTIONS_X = { 1, -1, 0, 0 };
    private static final int[] DIRECTIONS_Y = { 0, 0, 1, -1 };

    public int solution(String[] board) {
        String[][] map = new String[board.length][board[0].length()];
        boolean[][] visited = new boolean[board.length][board[0].length()];
        int[] start = new int[2];

        for (int i = 0; i < board.length; i++) {
            String[] temp = board[i].split("");

            for (int j = 0; j < temp.length; j++) {
                map[i][j] = temp[j];

                if (temp[j].equals("R")) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { start[0], start[1], 0 });
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int y = q[0];
            int x = q[1];
            int cnt = q[2];

            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                // 끝까지 이동 ( 보드를 넘어가거나, 장애물에 부딪힐 때 stop )
                while (true) {
                    if (ny < 0 || ny >= map.length || nx < 0 || nx >= map[0].length) {
                        break;
                    }

                    if (map[ny][nx].equals("D")) {
                        nx -= DIRECTIONS_X[i];
                        ny -= DIRECTIONS_Y[i];
                        break;
                    }

                    nx += DIRECTIONS_X[i];
                    ny += DIRECTIONS_Y[i];
                }

                // 보드를 넘어갈 경우, 방향에 따라 위치 재조정
                if (ny < 0 || ny >= map.length || nx < 0 || nx >= map[0].length) {
                    if (i == 0) {
                        nx = map[0].length - 1;
                    } else if (i == 1) {
                        nx = 0;
                    } else if (i == 2) {
                        ny = map.length - 1;
                    } else {
                        ny = 0;
                    }
                }
                if (map[ny][nx].equals("G")) {
                    return cnt + 1;
                }

                if (!visited[ny][nx]) {
                    queue.add(new int[] { ny, nx, cnt + 1 });
                    visited[ny][nx] = true;
                }
            }
        }

        return -1;
    }

}
