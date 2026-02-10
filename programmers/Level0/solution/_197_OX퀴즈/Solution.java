package programmers.Level0.solution._197_OX퀴즈;

import java.util.Arrays;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120907?language=java">...</a>
 */
class Solution {

    public static void main(String[] args) {
        String[] quiz = {"3 - 4 = -3", "5 + 6 = 11"};
        String[] expectedResult = {"X", "O"};

        Solution solution = new Solution();
        String[] result = solution.solution(quiz);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] parts = quiz[i].split(" ");

            int x = Integer.parseInt(parts[0]);
            String operator = parts[1];
            int y = Integer.parseInt(parts[2]);
            int result = Integer.parseInt(parts[4]);

            int calculated = operator.equals("+") ? x + y : x - y;

            answer[i] = (calculated == result) ? "O" : "X";
        }

        return answer;
    }

}
