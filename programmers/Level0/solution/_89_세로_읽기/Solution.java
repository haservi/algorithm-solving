package programmers.Level0.solution._89_세로_읽기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181904?language=java
 */
class Solution {

    public static void main(String[] args) {
        String my_string = "ihrhbakrfpndopljhygc";
        int m = 4;
        int c = 2;
        String expectedResult = "happy";

        Solution solution = new Solution();
        String result = solution.solution(my_string, m, c);
        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String my_string, int m, int c) {
        StringBuilder answer = new StringBuilder();
        int rows = my_string.length() / m;

        // 각 행의 c번째 문자를 추출
        for (int i = 0; i < rows; i++) {
            int index = i * m + (c - 1);
            answer.append(my_string.charAt(index));
        }

        return answer.toString();
    }
}
