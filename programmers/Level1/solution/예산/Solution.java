package programmers.Level1.solution.예산;

import java.util.*;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int budget = 10;
    int[] d = { 2, 2, 3, 3 };
    int result = solution.solution(d, budget);
    System.out.println("결과 : " + result);
  }

  public int solution(int[] d, int budget) {
    Arrays.sort(d);
    int count = d.length;

    int answer = 0;
    int sumMoney = 0;
    for (int i = 0; i < count; i++) {
      sumMoney += d[i];
      if (sumMoney <= budget) {
        answer++;
      } else {
        break;
      }
    }

    return answer;
  }

}
