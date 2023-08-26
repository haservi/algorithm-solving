package programmers.Level1.solution._69_명예의_전당;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int k = 3;
        int[] score = { 10, 100, 20, 150, 1, 100, 200 };
        int[] expectedResult = { 10, 10, 10, 20, 20, 100, 100 };

        Solution solution = new Solution();
        int[] result = solution.solution(k, score);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] scoreRanking = new int[k];

        for (int i = 0; i < score.length; i++) {
            // 스코어 점수가 명예 전당값 보다 높을때만 저장
            if (scoreRanking[0] < score[i]) {
                scoreRanking[0] = score[i];
                Arrays.sort(scoreRanking);
            }
            // k 가 더 큰 경우는 정렬이 모두 안된 상태
            if (i < k) {
                answer[i] = scoreRanking[k - i - 1];
            } else {
                answer[i] = scoreRanking[0];
            }
        }
        return answer;
    }

}
