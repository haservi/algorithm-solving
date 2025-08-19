package programmers.Level0.solution._173_이차원_배열_대각선_순회하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181829?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[][] board = {
                { 0, 1, 2 },
                { 1, 2, 3 },
                { 2, 3, 4 },
                { 3, 4, 5 } };
        int k = 2;
        int expectedResult = 8;

        Solution solution = new Solution();
        int result = solution.solution(board, k);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[][] board, int k) {
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i + j) <= k) {
                    answer += board[i][j];
                }
            }
        }
        return answer;
    }
}
