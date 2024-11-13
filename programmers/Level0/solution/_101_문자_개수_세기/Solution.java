package programmers.Level0.solution._101_문자_개수_세기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181902?language=java
 */
class Solution {

    public static void main(String[] args) {
        String my_string = "Programmers";
        int[] expectedResult = {
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0,
                0, 1, 0, 1, 0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0 };

        Solution solution = new Solution();
        int[] result = solution.solution(my_string);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for (char c : my_string.toCharArray()) {
            // 대문자와 소문자를 각각 0~25, 26~51 위치에 저장
            int index = (c >= 'a') ? c - 'a' + 26 : c - 'A';
            answer[index]++;
        }
        return answer;
    }
}
