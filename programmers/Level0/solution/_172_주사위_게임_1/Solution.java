package programmers.Level0.solution._172_주사위_게임_1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181839?language=java
 */
class Solution {

    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int expectedResult = 34;

        Solution solution = new Solution();
        int result = solution.solution(a, b);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int a, int b) {
        boolean isAOdd = (a % 2) == 1;
        boolean isBOdd = (b % 2) == 1;

        if (isAOdd && isBOdd) {
            return (a * a) + (b * b);
        }

        if (isAOdd || isBOdd) {
            return 2 * (a + b);
        }

        return Math.abs(a - b);
    }
}
