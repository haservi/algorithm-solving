package programmers.Level0.solution._161_문자열_잘라서_정렬하기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181866?language=java
 */
class Solution {

    public static void main(String[] args) {
        String myString = "axbxcxd";
        String[] expectedResult = { "a", "b", "c", "d" };

        Solution solution = new Solution();
        String[] result = solution.solution(myString);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(String myString) {
        String[] split = Arrays.stream(myString.split("x"))
                .filter(s -> !s.isEmpty())
                .sorted()
                .toArray(String[]::new);
        return split;
    }
}
