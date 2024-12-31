package programmers.Level0.solution._124_모스부호_1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120838?language=java
 */
class Solution {

    public static void main(String[] args) {
        String letter = ".... . .-.. .-.. ---";
        String expectedResult = "hello";

        Solution solution = new Solution();
        String result = solution.solution(letter);

        if (result.equals(expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private static final Map<String, String> MORSE_MAP = new HashMap<>();

    static {
        MORSE_MAP.put(".-", "a");
        MORSE_MAP.put("-...", "b");
        MORSE_MAP.put("-.-.", "c");
        MORSE_MAP.put("-..", "d");
        MORSE_MAP.put(".", "e");
        MORSE_MAP.put("..-.", "f");
        MORSE_MAP.put("--.", "g");
        MORSE_MAP.put("....", "h");
        MORSE_MAP.put("..", "i");
        MORSE_MAP.put(".---", "j");
        MORSE_MAP.put("-.-", "k");
        MORSE_MAP.put(".-..", "l");
        MORSE_MAP.put("--", "m");
        MORSE_MAP.put("-.", "n");
        MORSE_MAP.put("---", "o");
        MORSE_MAP.put(".--.", "p");
        MORSE_MAP.put("--.-", "q");
        MORSE_MAP.put(".-.", "r");
        MORSE_MAP.put("...", "s");
        MORSE_MAP.put("-", "t");
        MORSE_MAP.put("..-", "u");
        MORSE_MAP.put("...-", "v");
        MORSE_MAP.put(".--", "w");
        MORSE_MAP.put("-..-", "x");
        MORSE_MAP.put("-.--", "y");
        MORSE_MAP.put("--..", "z");
    }

    public String solution(String letter) {
        StringBuilder answer = new StringBuilder();
        String[] splits = letter.split(" ");

        for (String morse : splits) {
            answer.append(MORSE_MAP.get(morse));
        }

        return answer.toString();
    }

}
