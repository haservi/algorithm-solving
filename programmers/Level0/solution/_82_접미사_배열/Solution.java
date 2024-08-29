package programmers.Level0.solution._82_접미사_배열;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181909?language=java
 */
class Solution {

    public static void main(String[] args) {
        String my_strings = "banana";
        String[] expectedResult = {"a", "ana", "anana", "banana", "na", "nana"};

        Solution solution = new Solution();
        String[] result = solution.solution(my_strings);
        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(String my_string) {
        int length = my_string.length();
        String[] answer = new String[length];

        // 뒤에서부터 잘라내어 배열에 저장
        for (int i = 0; i < length; i++) {
            answer[i] = my_string.substring(i);
        }

        // 오름차순으로 정렬
        Arrays.sort(answer);

        return answer;
    }
}
