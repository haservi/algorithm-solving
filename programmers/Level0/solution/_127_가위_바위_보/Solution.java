package programmers.Level0.solution._127_가위_바위_보;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120839?language=java
 */
class Solution {

    public static void main(String[] args) {
        String rsp = "2";
        String expectedResult = "0";

        Solution solution = new Solution();
        String result = solution.solution(rsp);

        if (result.equals(expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private static final char ROCK = '0';
    private static final char SCISSORS = '2';
    private static final char PAPER = '5';

    public String solution(String rsp) {
        StringBuilder answer = new StringBuilder();

        for (char c : rsp.toCharArray()) {
            switch (c) {
                case SCISSORS -> answer.append(ROCK);
                case ROCK -> answer.append(PAPER);
                case PAPER -> answer.append(SCISSORS);
                default -> throw new AssertionError("Invalid character: " + c);
            }
        }

        return answer.toString();
    }

}
