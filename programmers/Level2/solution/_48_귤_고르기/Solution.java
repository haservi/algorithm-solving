package programmers.Level2.solution._48_귤_고르기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = { 1, 3, 2, 5, 4, 5, 2, 3 };
        long expectedResult = 3;

        Solution solution = new Solution();
        long result = solution.solution(k, tangerine);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int k, int[] tangerine) {
        // 귤의 크기별 개수 판단
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        // 귤의 개수를 내림차순으로 정렬
        ArrayList<Integer> counts = new ArrayList<>(map.values());
        Collections.sort(counts, Collections.reverseOrder());

        // k를 채우기 위해 가장 많은 개수의 귤부터 선택
        int sum = 0;
        int answer = 0;
        for (int count : counts) {
            sum += count;
            answer++;
            if (sum >= k) {
                break;
            }
        }

        return answer;
    }

}
