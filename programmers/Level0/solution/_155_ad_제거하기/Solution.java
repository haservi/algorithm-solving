package programmers.Level0.solution._155_ad_제거하기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181870?language=java
 */
class Solution {

    public static void main(String[] args) {
        String[] myStr = { "and", "notad", "abcd" };
        String[] expectedResult = { "and", "abcd" };

        Solution solution = new Solution();
        String[] result = solution.solution(myStr);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(String[] strArr) {
        return Arrays.stream(strArr)
                .filter(s -> !s.contains("ad"))
                .toArray(String[]::new);
    }
}
