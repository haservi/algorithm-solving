package programmers.Level2.주식가격;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] prices = { 1, 2, 3, 2, 3 };

    int[] result = solution.solution(prices);
    System.out.println("결과: " + Arrays.toString(result));
  }

  public int[] solution(int[] prices) {
    Stack<Integer> beginIdxs = new Stack<>();
    int i = 0;
    int[] terms = new int[prices.length];

    beginIdxs.push(i);
    for (i = 1; i < prices.length; i++) {
      while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
        int beginIdx = beginIdxs.pop();
        terms[beginIdx] = i - beginIdx;
      }
      beginIdxs.push(i);
    }
    while (!beginIdxs.empty()) {
      int beginIdx = beginIdxs.pop();
      terms[beginIdx] = i - beginIdx - 1;
    }

    return terms;
  }
}
