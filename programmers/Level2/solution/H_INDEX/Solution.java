package programmers.Level2.solution.H_INDEX;

import java.util.Arrays;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] citations = { 1, 1, 2, 3, 4 };
    int result = solution.solution(citations);
    System.out.println("결과: " + result);
  }

  public int solution(int[] citations) {
    int answer = 0;
    Arrays.sort(citations);

    for (int i = 0; i < citations.length; i++) {
      int hIndex = citations.length - i;

      if (citations[i] >= hIndex) {
        answer = hIndex;
        break;
      }
    }
    return answer;
  }
}
