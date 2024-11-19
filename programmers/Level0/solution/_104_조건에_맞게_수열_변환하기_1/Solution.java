package programmers.Level0.solution._104_조건에_맞게_수열_변환하기_1;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181882?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 100, 99, 98 };
        int[] expectedResult = { 2, 2, 6, 50, 99, 49 };

        Solution solution = new Solution();
        int[] result = solution.solution(arr);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 50 && arr[i] % 2 == 0) {
                // 50보다 크고, 짝수라면 2로 나눔
                answer[i] = arr[i] / 2;
            } else if (arr[i] < 50 && arr[i] % 2 == 1) {
                // 50보다 작고, 홀수라면 2를 곱함
                answer[i] = arr[i] * 2;
            } else {
                answer[i] = arr[i];
            }
        }
        return answer;
    }
}
