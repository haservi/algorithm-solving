package programmers.Level0.solution._64_수열과_구간_쿼리_3;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181924?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4 };
        int[][] queries = { { 0, 3 }, { 1, 2 }, { 1, 4 } };
        int[] expectedResult = { 3, 4, 1, 0, 2 };

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
            int temp = arr[querie[0]];
            arr[querie[0]] = arr[querie[1]];
            arr[querie[1]] = temp;
        }
        return arr;
    }
}
