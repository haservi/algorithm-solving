package programmers.Level1.solution._46_성격_유형_검사하기;

import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666?language=java
 */
public class Solution {

    public static void main(String[] args) {

        String[] survey = { "AN", "CF", "MJ", "RT", "NA" };
        int[] choices = { 5, 3, 2, 7, 5 };

        Solution solution = new Solution();
        String result = solution.solution(survey, choices);
        System.out.println(result);

    }

    public String solution(String[] survey, int[] choices) {

        char[][] surveyType = { { 'R', 'T' }, { 'C', 'F' }, { 'J', 'M' }, { 'A', 'N' } };

        HashMap<Character, Integer> userMap = new HashMap<>();
        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            // 4점 미만인 경우 앞의 사람 점수 증가
            if (choice < 4) {
                char user = survey[i].charAt(0);
                userMap.put(user, userMap.getOrDefault(user, 0) + 4 - choice);

            } else if (4 < choice) { // 4점 초과인 경우 뒷 사람 점수가 증가
                char user = survey[i].charAt(1);
                userMap.put(user, userMap.getOrDefault(user, 0) + choice - 4);
            }
        }

        // 유저 타입에 따라 성격 유형 판단
        StringBuilder result = new StringBuilder();
        for (char[] type : surveyType) {
            int leftScore = userMap.getOrDefault(type[0], 0);
            int rightScore = userMap.getOrDefault(type[1], 0);
            if (rightScore <= leftScore) {
                result.append(type[0]);
            } else {
                result.append(type[1]);
            }
        }

        return result.toString();
    }

}
