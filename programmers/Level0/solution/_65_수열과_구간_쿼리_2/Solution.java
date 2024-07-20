package programmers.Level0.solution._65_수열과_구간_쿼리_2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181923?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 4, 3 };
        int[][] queries = { { 0, 4, 2 }, { 0, 3, 2 }, { 0, 2, 2 } };
        int[] expectedResult = { 3, 4, -1 };

        Solution solution = new Solution();
        int[] result = solution.solution(arr, queries);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int s = queries[q][0];
            int e = queries[q][1];
            int k = queries[q][2];

            int minValue = Integer.MAX_VALUE;
            boolean found = false;

            for (int i = s; i <= e; i++) {
                if (arr[i] > k && arr[i] < minValue) {
                    minValue = arr[i];
                    found = true;
                }
            }

            if (found) {
                answer[q] = minValue;
            } else {
                answer[q] = -1;
            }
        }

        return answer;
    }
}
