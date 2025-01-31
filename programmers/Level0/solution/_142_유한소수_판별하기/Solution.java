package programmers.Level0.solution._142_유한소수_판별하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120878?language=java
 */
class Solution {

    public static void main(String[] args) {
        int a = 7;
        int b = 20;
        int expectedResults = 1;

        Solution solution = new Solution();
        int result = solution.solution(a, b);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int a, int b) {
        int number = b / calculateGCD(a, b);
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 5 == 0) {
            number /= 5;
        }

        return number == 1 ? 1 : 2;
    }

    public static int calculateGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return calculateGCD(num2, num1 % num2);
    }
}
