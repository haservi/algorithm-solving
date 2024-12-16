package programmers.Level0.solution._114_배열_만들기_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181895?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[][] intervals = { { 1, 3 }, { 0, 4 } };
        int[] expectedResult = { 2, 3, 4, 1, 2, 3, 4, 5 };

        Solution solution = new Solution();
        int[] result = solution.solution(arr, intervals);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> answer = new ArrayList<>();
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            for (int i = start; i <= end; i++) {
                answer.add(arr[i]);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(int[] arr, int[][] intervals) {
        // 최종 배열 크기 계산
        int totalLength = 0;
        for (int[] interval : intervals) {
            totalLength += (interval[1] - interval[0] + 1);
        }

        // 결과 배열 생성
        int[] answer = new int[totalLength];
        int index = 0;

        // 각 구간의 데이터 복사
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            System.arraycopy(arr, start, answer, index, end - start + 1);
            index += (end - start + 1);
        }

        return answer;
    }
}
