package programmers.pccp.solution._05_실습용_로봇;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/15009/lessons/121687?language=java
 */
public class Solution {

    public static void main(String[] args) {
        String command = "GRGLGRG";
        int[] expectedResult = { 2, 2 };

        Solution solution = new Solution();
        int[] result = solution.solution(command);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private static final int[] dx = { 0, 1, 0, -1 };
    private static final int[] dy = { 1, 0, -1, 0 };

    public int[] solution(String command) {
        int x = 0;
        int y = 0;
        int d = 0;

        for (char c : command.toCharArray()) {
            switch (c) {
                case 'R' -> d = (d + 1) % 4;
                case 'L' -> d = (d + 3) % 4;
                case 'G' -> {
                    x += dx[d];
                    y += dy[d];
                }
                case 'B' -> {
                    x -= dx[d];
                    y -= dy[d];
                }
            }
        }
        return new int[] { x, y };
    }
}
