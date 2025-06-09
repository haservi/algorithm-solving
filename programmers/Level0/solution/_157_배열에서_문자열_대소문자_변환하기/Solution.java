package programmers.Level0.solution._157_배열에서_문자열_대소문자_변환하기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181875?language=java
 */
class Solution {

    public static void main(String[] args) {
        String[] myString = { "AAA", "BBB", "CCC", "DDD" };
        String[] expectedResult = { "aaa", "BBB", "ccc", "DDD" };

        Solution solution = new Solution();
        String[] result = solution.solution(myString);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (i % 2 == 0) {
                strArr[i] = strArr[i].toLowerCase();
            } else {
                strArr[i] = strArr[i].toUpperCase();
            }
        }
        return strArr;
    }
}
