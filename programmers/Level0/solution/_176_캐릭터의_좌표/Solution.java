package programmers.Level0.solution._176_캐릭터의_좌표;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120861?language=java
 */
class Solution {

    public static void main(String[] args) {
        String[] keyinput = { "down", "down", "down", "down", "down" };
        int[] board = { 7, 9 };
        int[] expectedResult = { 0, -4 };

        Solution solution = new Solution();
        int[] result = solution.solution(keyinput, board);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        int maxX = board[0] / 2;
        int maxY = board[1] / 2;

        for (String key : keyinput) {
            switch (key) {
                case "left":
                    x = Math.max(x - 1, -maxX);
                    break;
                case "right":
                    x = Math.min(x + 1, maxX);
                    break;
                case "down":
                    y = Math.max(y - 1, -maxY);
                    break;
                case "up":
                    y = Math.min(y + 1, maxY);
                    break;
            }
        }

        return new int[] { x, y };
    }
}
