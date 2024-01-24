package programmers.Level3.solution._13_등굣길;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898
 */
public class Solution {

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = { { 2, 2 } };
        int expectedResult = 4;

        Solution solution = new Solution();
        int result = solution.solution(m, n, puddles);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int m, int n, int[][] puddles) {
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        // 웅덩이 체크
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for (int[] puddle : puddles) {
            isPuddle[puddle[1]][puddle[0]] = true;
        }
        int result = count(1, 1, m, n, isPuddle);
        return result;
    }

    private final int[][] mem = new int[101][101];

    private int count(int x, int y, int width, int height, boolean[][] isPuddle) {
        // 경로를 벗어난 경우
        if (width < x || height < y) {
            return 0;
        }
        // 웅덩이에 빠진 경우
        if (isPuddle[y][x]) {
            return 0;
        }
        // 메모이제이션 적용
        if (mem[x][y] != -1) {
            return mem[x][y];
        }
        // 도착한 경우
        if (x == width && y == height) {
            return 1;
        }

        // 아래로 가거나 오른쪽으로 가는 경우
        int total = count(x + 1, y, width, height, isPuddle) + count(x, y + 1, width, height, isPuddle);

        return mem[x][y] = total % 1_000_000_007;
    }

}
