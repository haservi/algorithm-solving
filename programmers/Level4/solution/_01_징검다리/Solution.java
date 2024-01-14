package programmers.Level4.solution._01_징검다리;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43236
 */
public class Solution {

    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = { 2, 14, 11, 21, 17 };
        int n = 2;
        int expectedResult = 4;

        Solution solution = new Solution();
        int result = solution.solution(distance, rocks, n);
        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int distance, int[] rocks, int n) {
        // 도착 지점과 마지막 바위 사이 거리 계산을 위한 작업
        rocks = Arrays.copyOf(rocks, rocks.length + 1);
        rocks[rocks.length - 1] = distance;
        Arrays.sort(rocks);

        int start = 1;
        int end = distance + 1;

        while (1 < (end - start)) {
            int d = (start + end) / 2;

            if (isValid(d, rocks, n)) {
                start = d;
            } else {
                end = d;
            }
        }

        return start;
    }

    private boolean isValid(int d, int[] rocks, int n) {
        int removed = 0;
        int last = 0;

        // 바위 사이의 거리가 d보다 작을 경우 바위 제거 및 제거한 바위 개수 저장
        for (int rock : rocks) {
            if (rock - last < d) {
                removed++;
                continue;
            }
            last = rock;
        }

        return removed <= n;
    }
}
