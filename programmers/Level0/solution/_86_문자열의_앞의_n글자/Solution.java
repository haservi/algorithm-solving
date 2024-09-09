package programmers.Level0.solution._86_문자열의_앞의_n글자;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181907?language=java
 */
class Solution {

    public static void main(String[] args) {
        String my_string = "ProgrammerS123";
        int n = 11;
        String expectedResult = "ProgrammerS";

        Solution solution = new Solution();
        String result = solution.solution(my_string, n);
        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String my_string, int n) {
        return my_string.substring(0, n);
    }

}
