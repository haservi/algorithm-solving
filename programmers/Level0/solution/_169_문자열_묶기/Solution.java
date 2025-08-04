package programmers.Level0.solution._169_문자열_묶기;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181855?language=java
 */
class Solution {

    public static void main(String[] args) {
        String[] strArr = { "a", "bc", "d", "efg", "hi" };
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution(strArr);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String[] strArr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String str : strArr) {
            map.put(str.length(), map.getOrDefault(str.length(), 0) + 1);
        }

        int answer = 0;
        for (int value : map.values()) {
            answer = Math.max(answer, value);
        }
        return answer;
    }
}
