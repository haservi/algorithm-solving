package programmers.Level1.solution.자릿수_더하기;

import java.util.Stack;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int s = 123;

    int result = solution.solution(s);
    System.out.println("결과 : " + result);
  }

  public int solution(int n) {
    Stack<Integer> stack = new Stack<Integer>();
    int answer = 0;
    while (n > 0) {
      stack.push(n % 10);
      n = n / 10;
    }
    while (!stack.isEmpty()) {
      answer += stack.pop();
    }

    System.out.println(answer);
    return answer;
  }
}
