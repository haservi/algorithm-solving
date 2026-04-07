package programmers.Level0.solution._205_암호_해독;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120892?language=java">...</a>
 */
class Solution {

    public static void main(String[] args) {
        String cipher = "dfjardstddetckdaccccdegk";
        int code = 4;
        String expectedResult = "attack";

        Solution solution = new Solution();
        String result = solution.solution(cipher, code);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String cipher, int code) {
        StringBuilder answer = new StringBuilder();

        for (int index = code - 1; index < cipher.length(); index += code) {
            answer.append(cipher.charAt(index));
        }

        return answer.toString();
    }
}
