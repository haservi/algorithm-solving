package programmers.Level0.solution._58_주사위_게임_2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181930?language=java
 */
class Solution {

    public static void main(String[] args) {
        int a = 2;
        int b = 6;
        int c = 1;
        int expectedResult = 9;

        Solution solution = new Solution();
        int result = solution.solution(a, b, c);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int a, int b, int c) {
        int answer = a + b + c;

        if (a == b || b == c || a == c) {
            answer *= (a * a + b * b + c * c);
        }

        if (a == b && b == c) {
            answer *= (a * a * a + b * b * b + c * c * c);
        }

        return answer;
    }
}
