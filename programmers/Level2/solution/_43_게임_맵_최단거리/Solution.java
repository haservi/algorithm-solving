package programmers.Level2.solution._43_게임_맵_최단거리;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[][] maps = {
                { 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 }
        };
        int expectedResult = 11;

        Solution solution = new Solution();
        int result = solution.solution(maps);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }

    private static int[] dx = { 0, 1, 0, -1 };
    private static int[] dy = { 1, 0, -1, 0 };

    public int solution(int[][] maps) {
        Queue<State> queue = new LinkedList<State>();
        queue.add(new State(0, 0, 1));
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];

        while (!queue.isEmpty()) {
            State state = queue.poll();

            // 최종 도착지점에 온 경우 return
            if (state.y == maps.length - 1 && state.x == maps[state.y].length - 1) {
                return state.step;
            }

            for (int d = 0; d < 4; d++) {
                int nx = state.x + dx[d];
                int ny = state.y + dy[d];

                // 게임 내 좌표를 벗어난 경우
                if (nx < 0 || ny < 0 || maps.length <= ny || maps[ny].length <= nx) {
                    continue;
                }

                // 길이 아닌 경우
                if (maps[ny][nx] != 1) {
                    continue;
                }

                if (isVisited[ny][nx]) {
                    continue;
                }

                isVisited[ny][nx] = true;
                queue.add(new State(nx, ny, state.step + 1));

            }
        }

        return -1;
    }

    private static class State {
        private int x;
        private int y;
        private int step;

        private State(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

}
