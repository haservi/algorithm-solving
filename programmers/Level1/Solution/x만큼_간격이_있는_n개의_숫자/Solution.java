package programmers.Level1.Solution.x만큼_간격이_있는_n개의_숫자;

import java.util.Arrays;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    long[] result = solution.solution(-4, 5);
    System.out.println("결과 : " + Arrays.toString(result));
  }

  public long[] solution(int x, int n) {
    long[] answer = new long[n];

    for (int i = 1; i <= n; i++) {
      int value = x * i;
      answer[i - 1] = value;
    }
    return answer;
  }
}
