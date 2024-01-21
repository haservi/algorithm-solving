package programmers.Level1.solution._01_완주하지_못한_선수;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120804
 */
class Solution {
    public static void main(String[] args) {
        String[] participant = { "leo", "kiki", "eden" };
        String[] completion = { "eden", "kiki" };
        String expectedResult = "leo";

        Solution solution = new Solution();
        String result = solution.solution2(participant, completion);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    /**
     * 1. 정렬 후 일치하지 않은 선수를 출력
     */
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[i];
    }

    public String solution2(String[] participant, String[] completion) {
        Map<String, Integer> count = new HashMap<>();

        for (String name : participant) {
            count.putIfAbsent(name, 0);
            count.put(name, count.get(name) + 1);
        }

        for (String name : completion) {
            int v = count.get(name) - 1;
            count.put(name, v);
            if (v == 0) {
                count.remove(name);
            }
        }

        return count.keySet().iterator().next();
    }
}
