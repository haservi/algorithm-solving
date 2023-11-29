package programmers.Level1.solution._41_모의고사;

import java.util.*;
import java.util.stream.IntStream;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class Solution {
    public static void main(String args[]) {
        int[] answers = { 1, 3, 2, 4, 2 };
        int[] expectedResult = { 1, 2, 3 };

        Solution solution = new Solution();
        int[] result = solution.solution(answers);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
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

    private static final int[][] RULES = {
            { 1, 2, 3, 4, 5 },
            { 2, 1, 2, 3, 2, 4, 2, 5 },
            { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 },
    };

    public int[] solution2(int[] answers) {
        int[] corrects = new int[3];
        int max = 0;

        for (int problem = 0; problem < answers.length; problem++) {
            int answer = answers[problem];

            for (int person = 0; person < 3; person++) {
                int picked = getPicked(person, problem);
                if (answer == picked) {
                    if (++corrects[person] > max) {
                        max = corrects[person];
                    }
                }
            }
        }

        // 람다 혹은 익명 메서드로 전달되는 메서드에서 외부 변수 참조 시에는 final 키워드 명시
        final int maxCorrects = max;
        return IntStream.range(0, 3)
                .filter(i -> corrects[i] == maxCorrects)
                .map(i -> i + 1)
                .toArray();
    }

    private int getPicked(int person, int problem) {
        int[] rule = RULES[person];
        int index = problem % rule.length;
        return rule[index];
    }
}
