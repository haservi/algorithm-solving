package programmers.Level0.solution._158_공백으로_구분하기_1;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181869?language=java
 */
class Solution {

    public static void main(String[] args) {
        String myString = "i love you";
        String[] expectedResult = { "i", "love", "you" };

        Solution solution = new Solution();
        String[] result = solution.solution(myString);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(String myString) {
        return myString.split(" ");
    }
}
