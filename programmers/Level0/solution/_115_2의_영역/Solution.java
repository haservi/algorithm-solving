package programmers.Level0.solution._115_2의_영역;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181894?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 4, 5, 2, 9 };
        int[] expectedResult = { 2, 1, 4, 5, 2 };

        Solution solution = new Solution();
        int[] result = solution.solution(arr);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr) {
        int startIndex = -1;
        int endIndex = -1;

        // 첫 번째로 2를 찾는 인덱스
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                startIndex = i;
                break;
            }
        }

        // 마지막으로 2를 찾는 인덱스
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 2) {
                endIndex = i;
                break;
            }
        }

        // 2가 없는 경우
        if (startIndex == -1 || endIndex == -1) {
            return new int[]{-1};
        }

        // 부분 배열 생성
        int[] answer = new int[endIndex - startIndex + 1];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr[startIndex + i];
        }

        return answer;
    }
}
