package programmers.Level2.solution._56_무인도_여행;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540?language=java
 */
public class Solution {

    public static void main(String[] args) {
        String[] maps = { "X591X", "X1X5X", "X231X", "1XXX1" };
        int[] expectedResult = { 1, 1, 27 };

        Solution solution = new Solution();
        int[] result = solution.solution(maps);

        if (Arrays.equals(result, expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private static final int[] dx = { 0, 1, 0, -1 };
    private static final int[] dy = { 1, 0, -1, 0 };

    public int[] solution(String[] maps) {
        int[][] map = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            char[] charArray = maps[i].toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[j] == 'X') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = Character.getNumericValue(charArray[j]);
                }
            }
        }

        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited[i][j] && map[i][j] != -1) {
                    int lifeDay = dfs(map, visited, i, j);
                    answerList.add(lifeDay);
                }
            }
        }

        if (answerList.isEmpty()) {
            return new int[] { -1 };
        }

        Collections.sort(answerList);
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(int[][] map, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        int lifeDay = map[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && 0 <= ny && nx < map.length && ny < map[0].length && !visited[nx][ny] && map[nx][ny] != -1) {
                lifeDay += dfs(map, visited, nx, ny);
            }
        }
        return lifeDay;
    }

}
