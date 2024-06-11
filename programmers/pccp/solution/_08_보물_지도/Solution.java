package programmers.pccp.solution._08_보물_지도;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/15009/lessons/121690?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] hole = { { 2, 3 }, { 3, 3 } };
        int expectedResult = 5;

        Solution solution = new Solution();
        int result = solution.solution(n, m, hole);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private static final int[] dx = { 0, 1, 0, -1 };
    private static final int[] dy = { 1, 0, -1, 0 };

    public int solution(int n, int m, int[][] hole) {
        // true는 이동 가능, false는 이동 불가능
        boolean[][] map = new boolean[m][n];
        for (boolean[] row : map) {
            Arrays.fill(row, true);
        }

        // map에서 hole의 위치를 false로 설정
        for (int[] h : hole) {
            int x = h[0] - 1;
            int y = h[1] - 1;
            map[y][x] = false;
        }

        // 방문 여부를 저장하는 3차원 배열
        // isVisited[y][x][0]은 점프 불가능 상태에서 방문 여부
        // isVisited[y][x][1]은 점프 가능 상태에서 방문 여부
        boolean[][][] isVisited = new boolean[m][n][2];
        Queue<State> q = new LinkedList<>();

        // 시작점 (0, 0)에서 점프 가능 상태로 큐에 추가
        q.add(new State(0, 0, 1, 0));
        isVisited[0][0][1] = true;

        // BFS 순회
        while (!q.isEmpty()) {
            State s = q.poll();

            // 목적지에 도착한 경우
            if (s.x == n - 1 && s.y == m - 1) {
                return s.step;
            }

            for (int d = 0; d < 4; d++) {
                int nx = s.x + dx[d];
                int ny = s.y + dy[d];

                // 이동할 수 없는 경우 제외 (경계를 벗어나는 경우)
                if (ny < 0 || m <= ny || nx < 0 || n <= nx) {
                    continue;
                }

                // 이동할 수 있는 경우
                if (map[ny][nx]) {
                    // 이미 방문한 경우 제외
                    if (isVisited[ny][nx][s.canJump]) {
                        continue;
                    }
                    isVisited[ny][nx][s.canJump] = true;
                    q.add(new State(nx, ny, s.canJump, s.step + 1));
                }

                // 점프할 수 없는 상태라면 점프 시도 제외
                if (s.canJump != 1) {
                    continue;
                }

                // 점프해서 이동할 좌표 계산
                int nnx = nx + dx[d];
                int nny = ny + dy[d];

                // 점프 후 이동할 수 없는 경우 제외 (경계를 벗어나는 경우)
                if (nny < 0 || m <= nny || nnx < 0 || n <= nnx) {
                    continue;
                }
                // 점프한 위치가 함정인 경우 제외
                if (!map[nny][nnx]) {
                    continue;
                }
                // 점프 후 이미 방문한 경우 제외
                if (isVisited[nny][nnx][0]) {
                    continue;
                }
                isVisited[nny][nx][0] = true;
                q.add(new State(nnx, nny, 0, s.step + 1));
            }
        }

        // 목적지에 도착할 수 없는 경우 -1 반환
        return -1;
    }

    private static class State {
        public final int x;
        public final int y;
        public final int canJump;
        public final int step;

        public State(int x, int y, int canJump, int step) {
            this.x = x;
            this.y = y;
            this.canJump = canJump;
            this.step = step;
        }
    }

}
