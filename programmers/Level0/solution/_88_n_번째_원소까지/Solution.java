package programmers.Level0.solution._88_n_번째_원소까지;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181889?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] num_list = { 2, 1, 6 };
        int n = 1;
        int[] expectedResult = { 2 };

        Solution solution = new Solution();
        int[] result = solution.solution(num_list, n);
        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] num_list, int n) {
        return Arrays.copyOf(num_list, n);
    }
}
