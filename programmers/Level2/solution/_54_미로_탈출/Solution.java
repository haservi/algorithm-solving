package programmers.Level2.solution._54_미로_탈출;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/159993?language=java
 */
public class Solution {

    public static void main(String[] args) {
        String[] maps = { "SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE" };
        int expectedResult = 16;

        Solution solution = new Solution();
        int result = solution.solution(maps);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private static int[] dx = { 0, 1, 0, -1 };
    private static int[] dy = { 1, 0, -1, 0 };

    public int solution(String[] maps) {
        int rowCount = maps.length;
        int columnCount = maps[0].length();
        char[][] map = new char[rowCount][columnCount];

        int[] start = new int[2];
        int[] lever = new int[2];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                map[i][j] = maps[i].charAt(j);

                if (map[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }

                if (map[i][j] == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }

        int result = bfs(map, start, 'L');
        int result2 = bfs(map, lever, 'E');

        if (result == -1 || result2 == -1)
            return -1;

        return result + result2;
    }

    public int bfs(char[][] map, int[] start, char target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { start[0], start[1], 0 });

        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            if (map[x][y] == target) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length && !visited[nx][ny]) {
                    if (map[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        queue.add(new int[] { nx, ny, count + 1 });
                    }
                }
            }
        }

        return -1;
    }

}
