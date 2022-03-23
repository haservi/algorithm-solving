package programmers.Level3.입국심사;

import java.util.Arrays;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int n = 10;
    int[] times = { 7, 10 };

    long result = solution.solution(n, times);
    System.out.println("결과 : " + result);
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

      // 그렇지 않은 경우 시작 시간 추가
      } else {
        left = mid + 1;
      }
    }
    return answer;
  }
}