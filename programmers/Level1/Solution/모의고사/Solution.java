package programmers.Level1.Solution.모의고사;

import java.util.*;

public class Solution {

    public static void main(String args[]) {

        Solution solution = new Solution();

        System.out.println("Test");
        // int[] answers = { 1, 2, 3, 4, 5 };
        // int[] answers = { 1, 3, 2, 4, 2 };
        int[] answers = { 3, 3, 1, 3, 2, 4, 2 };
        int[] result = solution.solution(answers);

        System.out.println("result = " + Arrays.toString(result));
    }

    public int[] solution(int[] answers) {

        int[] user1Pattern = { 1, 2, 3, 4, 5 };
        int[] user2Pattern = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] user3Pattern = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        int[] winners = new int[3];
        List<Integer> countNum = new ArrayList<>();

        // 해당 유저가 점수를 맞출 경우 userScores
        for (int i = 0; i < answers.length; i++) {
            if (user1Pattern[i % user1Pattern.length] == answers[i])
                winners[0]++;
            if (user2Pattern[i % user2Pattern.length] == answers[i])
                winners[1]++;
            if (user3Pattern[i % user3Pattern.length] == answers[i])
                winners[2]++;
        }

        // 고득점 찾기
        int maxNum = Math.max(winners[0], Math.max(winners[1], winners[2]));

        // 동점자 찾기
        for (int i = 0; i < winners.length; i++) {
            if (winners[i] == maxNum) {
                countNum.add(i);
            }
        }

        // 결과 출력
        int[] answer = {};
        answer = new int[countNum.size()];
        for (int i = 0; i < countNum.size(); i++) {
            answer[i] = countNum.get(i) + 1;
        }
        return answer;
    }

}
