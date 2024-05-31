package programmers.Level0.solution._55_코드_처리하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181932?language=java
 */
class Solution {

    public static void main(String[] args) {
        String code = "abc1abc1abc";
        String expectedResult = "acbac";

        Solution solution = new Solution();
        String result = solution.solution(code);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        char[] charArray = code.toCharArray();
        boolean isMode = false; // 0: false, 1: on
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '1') {
                isMode = !isMode;

            } else if (!isMode && (i % 2 == 0)) {
                answer.append(charArray[i]);

            } else if (isMode && (i % 2 == 1)) {
                answer.append(charArray[i]);
            }
        }
        if (answer.isEmpty()) {
            return "EMPTY";
        }
        return answer.toString();
    }
}
