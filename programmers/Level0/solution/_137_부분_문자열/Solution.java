package programmers.Level0.solution._137_부분_문자열;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181842?language=java
 */
class Solution {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "aabcc";
        int expectedResults = 1;

        Solution solution = new Solution();
        int result = solution.solution(str1, str2);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String str1, String str2) {
        return str2.contains(str1) ? 1 : 0;
    }
}
