package programmers.Level1.solution._31_자릿수_더하기;

import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12931
 * 1. Stack을 이용하여 10의 나머지 값을 push 한다.
 * 2. 더이상 나눌 수 없을 경우 pop 하여 모든 값을 더해준다.
 */
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
