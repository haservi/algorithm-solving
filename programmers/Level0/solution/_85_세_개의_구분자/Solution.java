package programmers.Level0.solution._85_세_개의_구분자;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181862?language=java
 */
class Solution {

    public static void main(String[] args) {
        String myStr = "baconlettucetomato";
        String[] expectedResult = { "onlettu", "etom", "to" };

        Solution solution = new Solution();
        String[] result = solution.solution(myStr);
        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(String myStr) {
        // "a", "b", "c"를 "-"로 대체한 후 split
        String[] answer = myStr.replaceAll("[abc]", "-")
                .split("-");

        // 빈 문자열을 제거한 결과만 남김
        answer = Arrays.stream(answer)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

        if (answer.length == 0) {
            return new String[] { "EMPTY" };
        }

        return answer;
    }

}
