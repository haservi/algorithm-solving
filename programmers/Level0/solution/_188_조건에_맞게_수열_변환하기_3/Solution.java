package programmers.Level0.solution._188_조건에_맞게_수열_변환하기_3;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181835?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 100, 99, 98};
        int k = 3;
        int[] expectedResult = {3, 6, 9, 300, 297, 294};

        Solution solution = new Solution();
        int[] result = solution.solution(arr, k);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr, int k) {
        if (k % 2 == 0) {
            for (int i = 0; i < arr.length; i++)
                arr[i] = arr[i] + k;
        } else {
            for (int i = 0; i < arr.length; i++)
                arr[i] = arr[i] * k;
        }
        return arr;
    }
}
