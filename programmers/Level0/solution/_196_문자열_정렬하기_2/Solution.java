package programmers.Level0.solution._196_문자열_정렬하기_2;

import java.util.Arrays;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120911?language=java">...</a>
 */
class Solution {

    public static void main(String[] args) {
        String myString = "Bcad";
        String expectedResult = "abcd";

        Solution solution = new Solution();
        String result = solution.solution(myString);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String my_string) {
        char[] chars = my_string.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
