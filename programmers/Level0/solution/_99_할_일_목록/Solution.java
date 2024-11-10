package programmers.Level0.solution._99_할_일_목록;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181885?language=java
 */
class Solution {

    public static void main(String[] args) {
        String[] todo_list = { "problemsolving", "practiceguitar", "swim", "studygraph" };
        boolean[] finished = { true, false, true, false };
        String[] expectedResult = { "practiceguitar", "studygraph" };

        Solution solution = new Solution();
        String[] result = solution.solution(todo_list, finished);

        if (Arrays.equals(result, expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(String[] todo_list, boolean[] finished) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < todo_list.length; i++) {
            if (!finished[i]) {
                stringBuilder.append(todo_list[i]).append(" ");
            }
        }

        return stringBuilder.toString().split(" ");
    }
}
