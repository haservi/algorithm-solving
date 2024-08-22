package programmers.Level0.solution._77_부분_문자열_이어_붙여_문자열_만들기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181911?language=java
 */
class Solution {

    public static void main(String[] args) {
        String[] my_strings = { "progressive", "hamburger", "hammer", "ahocorasick" };
        int[][] parts = { { 0, 4 }, { 1, 2 }, { 3, 5 }, { 7, 7 } };
        String expectedResult = "programmers";

        Solution solution = new Solution();
        String result = solution.solution(my_strings, parts);
        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < my_strings.length; i++) {
            answer.append(my_strings[i], parts[i][0], parts[i][1] + 1);
        }
        return answer.toString();
    }
}
