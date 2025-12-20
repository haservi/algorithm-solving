package programmers.Level0.solution._184_0_떼기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181847?language=java
 *
 */
class Solution {

    public static void main(String[] args) {
        String n_str = "0010";
        String expectedResult = "10";

        Solution solution = new Solution();
        String result = solution.solution(n_str);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String n_str) {
        return String.valueOf(Integer.parseInt(n_str));
    }
}
