package programmers.Level1.lv1_42_자연수_뒤집어_배열로_만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    long s = 812345;

    int[] result = solution.solution(s);
    System.out.println("결과 : " + Arrays.toString(result));
  }

  public int[] solution(long n) {
    Stack<Long> stack = new Stack<Long>();
    while (n > 0) {
      stack.push(n % 10);
      n = n / 10;
    }
    List<Long> longList = new ArrayList<Long>();
    while (!stack.isEmpty()) {
      longList.add(stack.pop());
    }

    // 값 삽입
    int[] answer = new int[longList.size()];
    int count = longList.size();
    for (int i = 0; i < count; i++) {
      answer[i] = longList.get(count - i - 1).intValue();
    }

    System.out.println(longList);
    return answer;
  }
}
