package programmers.Level0.solution._116_n_번째_원소부터;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181892?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] num_list = { 2, 1, 6 };
        int n = 3;
        int[] expectedResult = { 6 };

        Solution solution = new Solution();
        int[] result = solution.solution(num_list, n);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] num_list, int n) {
        return Arrays.copyOfRange(num_list, n - 1, num_list.length);
    }

}
