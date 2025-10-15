package programmers.Level0.solution._181_배열의_길이를_2의_거듭제곱으로_만들기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181857?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int[] expectedResult = { 1, 2, 3, 4, 5, 6, 0, 0 };

        Solution solution = new Solution();
        int[] result = solution.solution(arr);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr) {
        int arrLength = arr.length;

        // arr 길이보다 큰 가장 작은 2의 거듭제곱 찾기
        int targetLength = 1;
        while (targetLength < arrLength) {
            targetLength *= 2;
        }

        return Arrays.copyOf(arr, targetLength);
    }
}
