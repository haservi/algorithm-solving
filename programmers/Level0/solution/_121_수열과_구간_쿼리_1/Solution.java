package programmers.Level0.solution._121_수열과_구간_쿼리_1;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181883?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4 };
        int[][] queries = { { 0, 1 }, { 1, 2 }, { 2, 3 } };
        int[] expectedResult = { 1, 3, 4, 4, 4 };

        Solution solution = new Solution();
        int[] result = solution.solution(arr, queries);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[1]; i++) {
                arr[i]++;
            }
        }

        return arr;
    }

}
