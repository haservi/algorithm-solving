package baekjoon.problem._016_지뢰_찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/4396
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mapSize = Integer.parseInt(br.readLine());

        boolean[][] mineMap = new boolean[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < mapSize; j++) {
                // 지뢰가 있는 곳은 true, 없는 곳은 false
                mineMap[i][j] = ch[j] == '*';
            }
        }

        boolean[][] playMap = new boolean[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < mapSize; j++) {
                // 사용자가 선택한 곳은 true, 선택하지 않은 곳은 false
                playMap[i][j] = ch[j] == 'x';
            }
        }

        System.out.print(solution(mineMap, playMap));
    }

    private static final int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static final int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static String solution(boolean[][] mineMap, boolean[][] playMap) {
        int n = mineMap.length;
        boolean isGameOver = false;
        String[][] resultMap = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (playMap[i][j]) {
                    if (mineMap[i][j]) {
                        isGameOver = true;
                    } else {
                        int count = 0;
                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && mineMap[nx][ny]) {
                                count++;
                            }
                        }
                        resultMap[i][j] = String.valueOf(count);
                    }
                } else {
                    resultMap[i][j] = ".";
                }
            }
        }

        // 게임이 끝난 경우 지뢰 위치를 모두 표시
        if (isGameOver) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mineMap[i][j]) {
                        resultMap[i][j] = "*";
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(resultMap[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
