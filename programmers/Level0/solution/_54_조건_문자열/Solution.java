package programmers.Level0.solution._54_조건_문자열;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181934?language=java
 */
class Solution {

    public static void main(String[] args) {
        String ineq = "<";
        String eq = "=";
        int n = 20;
        int m = 50;
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution(ineq, eq, n, m);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String ineq, String eq, int n, int m) {
        if (eq.equals("!")) {
            if (ineq.equals("<")) {
                return n < m ? 1 : 0;
            } else {
                return n > m ? 1 : 0;
            }
        } else if (eq.equals("=")) {
            if (ineq.equals("<")) {
                return n <= m ? 1 : 0;
            } else {
                return n >= m ? 1 : 0;
            }
        }
        return 0;
    }
}
