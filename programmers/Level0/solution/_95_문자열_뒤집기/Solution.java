package programmers.Level0.solution._95_문자열_뒤집기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181905?language=java
 */
class Solution {

    public static void main(String[] args) {
        String my_string = "Progra21Sremm3";
        int s = 6;
        int e = 12;
        String expectedResult = "ProgrammerS123";

        Solution solution = new Solution();
        String result = solution.solution(my_string, s, e);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String my_string, int s, int e) {
        String prefix = my_string.substring(0, s);
        String middle = new StringBuilder(my_string.substring(s, e + 1)).reverse().toString();
        String suffix = my_string.substring(e + 1);

        return prefix + middle + suffix;
    }
}
