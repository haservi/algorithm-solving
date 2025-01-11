package programmers.Level0.solution._135_문자열을_정수로_변환하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181848?language=java
 */
class Solution {

    public static void main(String[] args) {
        String n_str = "10";
        int expectedResults = 10;

        Solution solution = new Solution();
        int result = solution.solution(n_str);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String n_str) {
        return Integer.parseInt(n_str);
    }

}
