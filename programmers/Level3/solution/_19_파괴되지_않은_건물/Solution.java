package programmers.Level3.solution._19_파괴되지_않은_건물;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92344?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[][] board = { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } };
        int[][] skills = { { 1, 0, 0, 3, 4, 4 }, { 1, 2, 0, 2, 3, 2 }, { 2, 1, 0, 3, 1, 2 }, { 1, 0, 1, 3, 3, 1 } };
        int expectedResult = 10;

        Solution solution = new Solution();
        int result = solution.solution(board, skills);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[][] board, int[][] skills) {
        int[][] changes = new int[board.length + 1][board[0].length + 1];

        // 누적 배열 적용
        for (int[] skill : skills) {
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3] + 1;
            int c2 = skill[4] + 1;
            int power = skill[5];
            if (skill[0] == 1) {
                power = -power;
            }

            changes[r1][c1] += power;
            changes[r2][c1] -= power;
            changes[r1][c2] -= power;
            changes[r2][c2] += power;
        }

        // 변화된 값 계산
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (x > 0) {
                    changes[y][x] += changes[y][x - 1];
                }
                if (y > 0) {
                    changes[y][x] += changes[y - 1][x];
                }
                if (x > 0 && y > 0) {
                    changes[y][x] -= changes[y - 1][x - 1];
                }
            }
        }

        // 안전한 지역의 개수 계산
        int safe = 0;
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] + changes[y][x] > 0) {
                    safe++;
                }
            }
        }

        return safe;
    }

}
