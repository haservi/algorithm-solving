package programmers.Level2.solution._58_테이블_해시_함수;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/147354?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[][] data = { { 2, 2, 6 }, { 1, 5, 10 }, { 4, 2, 9 }, { 3, 8, 3 } };
        int col = 2;
        int row_begin = 2;
        int row_end = 3;
        int expectedResult = 4;

        Solution solution = new Solution();
        int result = solution.solution(data, col, row_begin, row_end);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[][] data, int col, int row_begin, int row_end) {

        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            } else {
                return o1[col - 1] - o2[col - 1];
            }
        });

        int answer = 0;
        for (int i = row_begin - 1; i < row_end; i++) {
            int si = 0;
            for (int j = 0; j < data[i].length; j++) {
                si += data[i][j] % (i + 1);
            }
            answer ^= si;
        }

        return answer;
    }
}
