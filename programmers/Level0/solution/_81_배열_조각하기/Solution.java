package programmers.Level0.solution._81_배열_조각하기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181893?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5};
        int[] query = {4, 1, 2};
        int[] expectedResult = {1, 2, 3};

        Solution solution = new Solution();
        int[] result = solution.solution(arr, query);
        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr, int[] query) {
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                // 배열을 슬라이싱하여 앞부분만 남김
                arr = Arrays.copyOfRange(arr, 0, query[i] + 1);
            } else {
                // 배열을 슬라이싱하여 뒷부분만 남김
                arr = Arrays.copyOfRange(arr, query[i], arr.length);
            }
        }
        return arr;
    }

    public int[] solution1(int[] arr, int[] query) {
        int start = 0;
        int end = arr.length - 1;
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                end = start + query[i] - 1;  // 끝 인덱스 조정
            } else {
                start += query[i];  // 시작 인덱스 조정
            }
        }

        return Arrays.copyOfRange(arr, start, end + 2);  // 범위에 해당하는 배열 반환
    }
}
