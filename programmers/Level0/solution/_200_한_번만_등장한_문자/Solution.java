package programmers.Level0.solution._200_한_번만_등장한_문자;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120896?language=java">...</a>
 */
class Solution {

    public static void main(String[] args) {
        String s = "abcabcadc";
        String expectedResult = "d";

        Solution solution = new Solution();
        String result = solution.solution(s);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        List<Character> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);

        StringBuilder answer = new StringBuilder();
        for (char c : result) {
            answer.append(c);
        }

        return answer.toString();
    }
}
