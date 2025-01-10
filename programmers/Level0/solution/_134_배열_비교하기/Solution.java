package programmers.Level0.solution._134_배열_비교하기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181856?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr1 = { 49, 13 };
        int[] arr2 = { 70, 11, 2 };
        int expectedResults = -1;

        Solution solution = new Solution();
        int result = solution.solution(arr1, arr2);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return arr1.length < arr2.length ? -1 : 1;
        }
        int arr1Sum = Arrays.stream(arr1).sum();
        int arr2Sum = Arrays.stream(arr2).sum();
        if (arr1Sum == arr2Sum) {
            return 0;
        }

        return arr1Sum < arr2Sum ? -1 : 1;
    }

}
