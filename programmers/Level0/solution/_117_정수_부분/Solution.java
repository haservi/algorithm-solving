package programmers.Level0.solution._117_정수_부분;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181850?language=java
 */
class Solution {

    public static void main(String[] args) {
        double flo = 1.42;
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution(flo);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(double flo) {
        return (int) flo;
    }

}
