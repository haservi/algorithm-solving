package programmers.Level1.solution.신고_결과_받기;

import java.util.Arrays;

class Solution {
  public static void main(String[] args) {

    Solution solution = new Solution();

    String[] id_list = { "muzi", "frodo", "apeach", "neo" };
    String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
    int k = 2;

    int[] result = solution.solution(id_list, report, k);

    System.out.println("result = " + Arrays.toString(result));

  }

  public int[] solution(String[] id_list, String[] report, int k) {
    int[] answer = {};
    return answer;
  }
}
