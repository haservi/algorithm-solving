package programmers.Level0.solution._66_수열과_구간_쿼리_4;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181923?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 4, 3 };
        int[][] queries = { { 0, 4, 1 }, { 0, 3, 2 }, { 0, 3, 3 } };
        int[] expectedResult = { 3, 2, 4, 6, 4 };

        Solution solution = new Solution();
        int[] result = solution.solution(arr, queries);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr, int[][] queries) {
        for (int[] querie : queries) {
            int s = querie[0];
            int e = querie[1];
            int k = querie[2];
            for (int i = s; i <= e; i++) {
                if (i % k == 0) {
                    arr[i] += 1;
                }
            }
        }

        return arr;
    }
}
