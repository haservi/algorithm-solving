package programmers.Level0.solution._195_문자열_밀기;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120921?language=java">...</a>
 */
class Solution {

    public static void main(String[] args) {
        String A = "atat";
        String B = "tata";
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution(A, B);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String A, String B) {
        if (A.equals(B)){
            return 0;
        }

        return (B + B).indexOf(A);
    }
}
