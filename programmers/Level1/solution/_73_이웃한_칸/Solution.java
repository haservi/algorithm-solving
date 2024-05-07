package programmers.Level1.solution._73_이웃한_칸;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250125?language=java
 */
public class Solution {

    public static void main(String[] args) {
        String[][] board = {
                { "yellow", "green", "blue" },
                { "blue", "green", "yellow" },
                { "yellow", "blue", "blue" }
        };
        int h = 1;
        int w = 1;
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution(board, h, w);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int answer = 0;
        int[] dh = { 0, 1, -1, 0 };
        int[] dw = { 1, 0, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int heightCheck = h + dh[i];
            int widthCheck = w + dw[i];

            if (heightCheck >= 0 && heightCheck < n && widthCheck >= 0 && widthCheck < n) {
                if (board[h][w].equals(board[heightCheck][widthCheck])) {
                    answer++;
                }
            }
        }
        return answer;
    }

}
