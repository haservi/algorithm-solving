package programmers.Level0.solution._180_등수_매기기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120882?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[][] score = { { 80, 70 }, { 90, 50 }, { 40, 70 }, { 50, 80 } };
        int[] expectedResult = { 1, 2, 4, 3 };

        Solution solution = new Solution();
        int[] result = solution.solution(score);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[][] score) {
        int n = score.length;
        double[] averages = new double[n];
        int[] answer = new int[n];

        // 각 학생의 평균 계산
        for (int i = 0; i < n; i++) {
            averages[i] = (score[i][0] + score[i][1]) / 2.0;
        }

        // 등수 계산
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (averages[j] > averages[i]) {
                    rank++;
                }
            }
            answer[i] = rank;
        }

        return answer;
    }
}
