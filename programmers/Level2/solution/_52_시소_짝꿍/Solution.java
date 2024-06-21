package programmers.Level2.solution._52_시소_짝꿍;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/152996?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[] weights = { 100, 180, 360, 100, 270 };
        int expectedResult = 4;

        Solution solution = new Solution();
        long result = solution.solution(weights);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> weightMap = new HashMap<>();

        // 각 무게가 몇 번 나오는지 세기
        for (int weight : weights) {
            weightMap.put(weight, weightMap.getOrDefault(weight, 0) + 1);
        }

        // 무게별로 순회하며 조건을 만족하는 쌍의 수 계산
        for (int weight1 : weightMap.keySet()) {
            int count1 = weightMap.get(weight1);

            // 같은 무게끼리 쌍을 이루는 경우 계산
            answer += (long) count1 * (count1 - 1) / 2;

            // 다른 무게끼리 쌍을 이루는 경우 계산
            for (int weight2 : weightMap.keySet()) {
                if (weight1 < weight2 && weightCheck(weight1, weight2)) {
                    answer += (long) count1 * weightMap.get(weight2);
                }
            }
        }

        return answer;
    }

    // 두 무게가 주어진 조건을 만족하는지 확인하는 함수
    private boolean weightCheck(int left, int right) {
        return left * 2 == right * 3 || left * 2 == right * 4
                || left * 3 == right * 2 || left * 3 == right * 4
                || left * 4 == right * 2 || left * 4 == right * 3;
    }

}
