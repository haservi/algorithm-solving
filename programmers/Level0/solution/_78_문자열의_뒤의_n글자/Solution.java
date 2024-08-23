package programmers.Level0.solution._78_문자열의_뒤의_n글자;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181910?language=java
 */
class Solution {

    public static void main(String[] args) {
        String my_strings = "ProgrammerS123";
        int n = 11;
        String expectedResult = "grammerS123";

        Solution solution = new Solution();
        String result = solution.solution(my_strings, n);
        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String my_string, int n) {
        return my_string.substring(my_string.length() - n);
    }
}
