package programmers.Level0.solution._182_배열의_길이에_따라_다른_연산하기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181854?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr1 = { 49, 12, 100, 276, 33 };
        int n = 27;
        int[] expectedResult = { 76, 12, 127, 276, 60 };

        Solution soution = new Solution();
        int[] result = soution.solution(arr1, n);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr, int n) {
        int start = (arr.length % 2 == 1) ? 0 : 1;

        for (int i = start; i < arr.length; i += 2) {
            arr[i] += n;
        }

        return arr;
    }

}
