package programmers.Level0.solution._47_중복된_문자_제거;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120888
 */
public class Solution {

    public static void main(String[] args) {
        String my_string = "people";
        String expectedResult = "peol";

        Solution solution = new Solution();
        String result = solution.solution(my_string);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String my_string) {
        Set<Character> used = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char c : my_string.toCharArray()) {
            if (used.contains(c)) {
                continue;
            }
            used.add(c);
            result.append(c);
        }
        return result.toString();
    }
}
