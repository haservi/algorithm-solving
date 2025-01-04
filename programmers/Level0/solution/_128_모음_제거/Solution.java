package programmers.Level0.solution._128_모음_제거;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120849?language=java
 */
class Solution {

    public static void main(String[] args) {
        String my_string = "nice to meet you";
        String expectedResult = "nc t mt y";

        Solution solution = new Solution();
        String result = solution.solution(my_string);

        if (result.equals(expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private static final Set<Character> VOWELS = new HashSet<>();

    static {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
    }

    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();

        for (char c : my_string.toCharArray()) {
            if (!VOWELS.contains(c)) {
                answer.append(c);
            }
        }

        return answer.toString();
    }

    public String solution1(String myString) {
        return myString.replaceAll("a|e|i|o|u", "");
    }

}
