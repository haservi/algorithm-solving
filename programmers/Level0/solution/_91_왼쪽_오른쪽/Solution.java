package programmers.Level0.solution._91_왼쪽_오른쪽;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181890?language=java
 */
class Solution {

    public static void main(String[] args) {
        String[] str_list = { "u", "u", "l", "r" };
        String[] expectedResult = { "u", "u" };

        Solution solution = new Solution();
        String[] result = solution.solution(str_list);

        if (Arrays.equals(result, expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(String[] str_list) {
        int index = 0;
        for (String string : str_list) {
            if (string.equals("l")) {
                return Arrays.copyOfRange(str_list, 0, index);
            }
            if (string.equals("r")) {
                return Arrays.copyOfRange(str_list, index + 1, str_list.length);
            }
            index++;
        }
        return new String[0];
    }
}
