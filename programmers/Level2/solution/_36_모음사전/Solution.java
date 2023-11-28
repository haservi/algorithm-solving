package programmers.Level2.solution._36_모음사전;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */
public class Solution {

    public static void main(String[] args) {
        String word = "AAAAE";
        int expectedResult = 6;

        Solution solution = new Solution();
        int result = solution.solution(word);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private static final char[] CHARS = "AEIOU".toCharArray();

    public int solution(String word) {
        return generate("").indexOf(word);
    }

    /**
     * 리스트를 복사하며, 최종적으로 ""를 기준으로 정렬된 리스트를 가짐
     */
    private List<String> generate(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);

        if (word.length() == 5)
            return words;

        for (char c : CHARS) {
            words.addAll(generate(word + c));
        }
        return words;
    }

    public int solution2(String word) {
        List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }

    /**
     * 매개변수로 정렬된 항목을 가짐
     */
    private void generate(String word, List<String> words) {
        words.add(word);

        if (word.length() == 5)
            return;
        for (char c : CHARS) {
            generate(word + c, words);
        }
    }

}
