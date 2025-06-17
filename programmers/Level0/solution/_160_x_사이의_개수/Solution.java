package programmers.Level0.solution._160_x_사이의_개수;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181867?language=java
 */
class Solution {

    public static void main(String[] args) {
        String myString = "oxooxoxxox";
        int[] expectedResult = { 1, 2, 1, 0, 1, 0 };

        Solution solution = new Solution();
        int[] result = solution.solution(myString);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(String myString) {
        // -1을 추가하여 빈 문자열도 포함
        String[] split = myString.split("x", -1);
        int[] answer = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            answer[i] = split[i].length();
        }

        return answer;
    }
}
