package baekjoon.problem._017_달팽이;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1913
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int boxSize = Integer.parseInt(br.readLine());
        int value = Integer.parseInt(br.readLine());

        String result = solution(boxSize, value);
        System.out.println(result);
    }

    // 방향: 위 → 오른쪽 → 아래 → 왼쪽
    private static final int[] dx = { -1, 0, 1, 0 };
    private static final int[] dy = { 0, 1, 0, -1 };

    private static String solution(int boxSize, int target) {
        int[][] map = new int[boxSize][boxSize];

        int x = boxSize / 2;
        int y = boxSize / 2;
        int value = 1;
        // 초기 방향: 위쪽
        int direction = 0;

        map[y][x] = value++;

        // 현재 이동해야 할 거리
        int step = 1;
        while (value <= boxSize * boxSize) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < step; j++) {
                    x += dx[direction];
                    y += dy[direction];
                    if (x >= 0 && x < boxSize && y >= 0 && y < boxSize) {
                        map[x][y] = value++;
                    }
                }
                // 방향 전환 (반시계 방향)
                direction = (direction + 1) % 4;
            }
            // 한 바퀴 돌 때마다 이동 거리 증가
            step++;
        }

        StringBuilder sb = new StringBuilder();
        int tx = 0, ty = 0;
        for (int i = 0; i < boxSize; i++) {
            for (int j = 0; j < boxSize; j++) {
                if (target == map[i][j]) {
                    ty = i + 1;
                    tx = j + 1;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(ty).append(" ").append(tx);
        return sb.toString();
    }

    private static String solution2(int boxSize, int target) {
        int[][] map = new int[boxSize][boxSize];
        int value = 1;

        int x = boxSize / 2;
        int y = boxSize / 2;

        int limit = 1;
        while (true) {
            for (int i = 0; i < limit; i++) {
                map[y--][x] = value++;
            }
            if (value - 1 == boxSize * boxSize)
                break;
            for (int i = 0; i < limit; i++) {
                map[y][x++] = value++;
            }

            limit++;
            for (int i = 0; i < limit; i++) {
                map[y++][x] = value++;
            }

            for (int i = 0; i < limit; i++) {
                map[y][x--] = value++;
            }
            limit++;
        }

        StringBuilder sb = new StringBuilder();
        int tx = 0, ty = 0;
        for (int i = 0; i < boxSize; i++) {
            for (int j = 0; j < boxSize; j++) {
                if (target == map[i][j]) {
                    ty = i + 1;
                    tx = j + 1;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(ty).append(" ").append(tx);
        return sb.toString();
    }

}
