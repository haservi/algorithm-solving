package programmers.Level0.solution._206_문자열_정렬하기_1;

import java.util.Arrays;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120850?language=java">...</a>
 */
class Solution {

    public static void main(String[] args) {
        String myString = "hi12392";
        int[] expectedResult = {1, 2, 2, 3, 9};

        Solution solution = new Solution();
        int[] result = solution.solution(myString);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(String my_string) {
        return my_string.chars()
                .filter(Character::isDigit)
                .map(this::toDigit)
                .sorted()
                .toArray();
    }

    private int toDigit(int c) {
        return c - '0';
    }

}
