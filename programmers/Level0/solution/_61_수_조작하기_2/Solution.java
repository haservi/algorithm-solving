package programmers.Level0.solution._61_수_조작하기_2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181925?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] numLog = { 0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1 };
        String expectedResult = "wsdawsdassw";

        Solution solution = new Solution();
        String result = solution.solution(numLog);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numLog.length - 1; i++) {
            int value = numLog[i + 1] - numLog[i];
            String s = findWord(value);
            answer.append(s);
        }
        return answer.toString();
    }

    private String findWord(int value) {
        return switch (value) {
            case 1 -> "w";
            case -1 -> "s";
            case 10 -> "d";
            case -10 -> "a";
            default -> throw new IllegalArgumentException("Unexpected value: " + value);
        };
    }
}
