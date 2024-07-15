package programmers.Level2.solution._61_혼자서_하는_틱택토;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/160585?language=java
 */
public class Solution {

    public static void main(String[] args) {
        String[] board = { "O.X", ".O.", "..X" };
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution(board);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String[] board) {
        if (!isValidBoard(board)) {
            return 0;
        }
        return 1;
    }

    private boolean isValidBoard(String[] board) {
        int oCount = 0;
        int xCount = 0;

        for (String line : board) {
            for (char cell : line.toCharArray()) {
                if (cell == 'O')
                    oCount++;
                else if (cell == 'X')
                    xCount++;
            }
        }

        // O가 선공이므로 O는 X보다 0 또는 1 많아야 함
        if (oCount != xCount && oCount != xCount + 1) {
            return false;
        }

        boolean oWins = checkWin(board, 'O');
        boolean xWins = checkWin(board, 'X');

        // 둘 다 이기는 경우는 없음
        if (oWins && xWins) {
            return false;
        }

        // O가 이긴 경우, O의 개수는 X의 개수보다 1 많아야 함
        if (oWins && oCount != xCount + 1) {
            return false;
        }

        // X가 이긴 경우, O의 개수는 X의 개수와 같아야 함
        if (xWins && oCount != xCount) {
            return false;
        }

        return true;
    }

    private boolean checkWin(String[] board, char player) {
        // 가로, 세로, 대각선 체크
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) {
                return true;
            }
            if (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) {
                return true;
            }
        }
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) {
            return true;
        }
        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) {
            return true;
        }
        return false;
    }
}
