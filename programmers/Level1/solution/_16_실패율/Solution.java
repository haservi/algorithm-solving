package programmers.Level1.solution._16_실패율;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 * 1. 게임 스테이지에 따른 실패비율의 값을 map에 넣은 후
 * 2. 맵의 value(=스테이지)의 값이 높은 순서대로 배열로 전환하였다.
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] test = { 4, 4, 4, 4, 4 };
        int[] result = solution.solution(4, test);
        System.out.println("결과 : " + Arrays.toString(result));
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        Map<Integer, Double> stageFailRateMap = new HashMap<Integer, Double>();
        int stageCount = N;
        int reminePlayers = stages.length;

        // 실패비율을 맵에 담기
        for (int i = 1; i <= stageCount; i++) {
            int failPlayers = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    failPlayers++;
                }
            }
            double failRate = 0;
            if (failPlayers != 0) {
                failRate = (double) failPlayers / reminePlayers;
            }
            stageFailRateMap.put(i, failRate);
            reminePlayers -= failPlayers;
        }

        // 실패율이 가장 큰 순서대로 값 넣기
        for (int i = 0; i < stageCount; i++) {
            double max = -1;
            int maxKey = 0;
            for (Integer key : stageFailRateMap.keySet()) {
                if (max < stageFailRateMap.get(key)) {
                    max = stageFailRateMap.get(key);
                    maxKey = key;
                }
            }
            answer[i] = maxKey;
            stageFailRateMap.remove(maxKey);
        }

        return answer;
    }
}
