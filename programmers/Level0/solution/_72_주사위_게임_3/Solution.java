package programmers.Level0.solution._72_주사위_게임_3;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181916?language=java
 */
class Solution {

    public static void main(String[] args) {
        int a = 2;
        int b = 2;
        int c = 2;
        int d = 2;
        int expectedResult = 2222;

        Solution solution = new Solution();
        int result = solution.solution(a, b, c, d);
        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int a, int b, int c, int d) {
        int answer = calcDiceScore(a, b, c, d);
        return answer;
    }

    public int calcDiceScore(int a, int b, int c, int d) {
        int[] dice = { a, b, c, d };
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int value : dice) {
            frequency.put(value, frequency.getOrDefault(value, 0) + 1);
        }

        if (frequency.size() == 1) {
            return 1111 * a;
        }

        if (frequency.size() == 2) {
            int[] keys = frequency.keySet().stream().mapToInt(Integer::intValue).toArray();
            int firstKey = keys[0];
            int secondKey = keys[1];
            int firstFreq = frequency.get(firstKey);
            int secondFreq = frequency.get(secondKey);

            if (firstFreq == 3 || secondFreq == 3) {
                int p = firstFreq == 3 ? firstKey : secondKey;
                int q = firstFreq == 3 ? secondKey : firstKey;
                return (int) Math.pow(10 * p + q, 2);
            }

            int p = firstKey;
            int q = secondKey;
            return (p + q) * Math.abs(p - q);
        }

        if (frequency.size() == 3) {
            int q = 0;
            for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
                if (entry.getValue() == 2) {
                } else if (q == 0) {
                    q = entry.getKey();
                }
            }
            return frequency.entrySet().stream()
                    .filter(entry -> entry.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .reduce((x, y) -> x * y)
                    .orElse(0);
        }

        return frequency.keySet().stream().min(Integer::compare).orElse(0);
    }

}
