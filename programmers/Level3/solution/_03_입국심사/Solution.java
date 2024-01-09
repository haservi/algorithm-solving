package programmers.Level3.solution._03_입국심사;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int n = 6;
        int[] times = { 7, 10 };
        long expectedResult = 28;

        Solution solution = new Solution();
        long result = solution.solution(n, times);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long left = 1;
        long right = (long) times[times.length - 1] * n;

        while (left <= right) {
            long people = 0;
            long mid = (left + right) / 2;

            // 평균 시간으로 심사할 수 있는 사람의 합
            for (int time : times) {
                people += (mid / time);
            }

            // 심사받을 사람보다 심사한 사람이 많을 경우 시간 단축
            if (n <= people) {
                right = mid - 1;
                answer = mid;

            } else { // 그렇지 않은 경우 시작 시간 추가
                left = mid + 1;
            }
        }
        return answer;
    }

    public long solution2(int n, int[] times) {
        long start = 1;
        long end = 1_000_000_000_000_000_000L;

        while (start < end) {
            long t = (start + end) / 2;

            if (isValid(t, n, times)) {
                end = t;
            } else {
                start = t + 1;
            }
        }

        return start;
    }

    private boolean isValid(long t, int n, int[] times) {
        long c = 0;
        for (int time : times) {
            c += t / time;
        }
        return n <= c;
    }
}
