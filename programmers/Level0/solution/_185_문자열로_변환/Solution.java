package programmers.Level0.solution._185_문자열로_변환;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181845?language=java
 */
class Solution {

    public static void main(String[] args) {
        int n1 = 123;
        String expectedResult1 = "123";

        Solution solution = new Solution();
        String result1 = solution.solution(n1);

        if (expectedResult1.equals(result1)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(int n) {
        return String.valueOf(n);
    }
}
