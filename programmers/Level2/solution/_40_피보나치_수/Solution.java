package programmers.Level2.solution._40_피보나치_수;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12945?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int n = 5;
        int expectedResult = 5;

        Solution solution = new Solution();
        int result = solution.solution(n);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }

    public int solution(int n) {
        Arrays.fill(mem, -1);
        for (int i = 0; i <= n; i++) {
            fibonacci(n);
        }
        return fibonacci(n);
    }

    private final int[] mem = new int[100_001];

    private int fibonacci(int n) {
        if (mem[n] != -1) {
            return mem[n];
        }
        if (n == 0 || n == 1) {
            return n;
        }
        return mem[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1_234_567;
    }

}
