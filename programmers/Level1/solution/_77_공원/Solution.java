package programmers.Level1.solution._77_공원;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/340198?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[] mats = { 5, 3, 2 };
        String[][] park = {
                { "A", "A", "-1", "B", "B", "B", "B", "-1" },
                { "A", "A", "-1", "B", "B", "B", "B", "-1" },
                { "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1" },
                { "D", "D", "-1", "-1", "-1", "-1", "E", "-1" },
                { "D", "D", "-1", "-1", "-1", "-1", "-1", "F" },
                { "D", "D", "-1", "-1", "-1", "-1", "E", "-1" }
        };
        int expectedResult = 3;

        Solution solution = new Solution();
        int result = solution.solution(mats, park);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] mats, String[][] park) {
        int maxSquareSize = findLargestSquare(park);

        int answer = -1;
        for (int mat : mats) {
            if (mat <= maxSquareSize) {
                answer = Math.max(answer, mat);
            }
        }
        return answer;
    }

    private int findLargestSquare(String[][] park) {
        int rows = park.length;
        int cols = park[0].length;

        int[][] dp = new int[rows][cols];
        int maxSize = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (park[i][j].equals("-1")) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 현재 위치에서 만들 수 있는 정사각형 크기를 계산
                        dp[i][j] = Math.min(
                                Math.min(dp[i - 1][j], dp[i][j - 1]),
                                dp[i - 1][j - 1]) + 1;
                    }
                    // 최대 정사각형 크기 갱신
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }

        return maxSize;
    }

}
