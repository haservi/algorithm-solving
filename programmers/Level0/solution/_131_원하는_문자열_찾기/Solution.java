package programmers.Level0.solution._131_원하는_문자열_찾기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181878?language=java
 */
class Solution {

    public static void main(String[] args) {
        String myString = "AbCdEfG";
        String pat = "aBc";
        int expectedResults = 1;

        Solution solution = new Solution();
        int result = solution.solution(myString, pat);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String myString, String pat) {
        if (myString.toLowerCase().contains(pat.toLowerCase())) {
            return 1;
        }
        return 0;
    }

}
