package programmers.Level2.solution._02_짝_지어_제거하기;

import java.util.Stack;

/**
 * 1. Stack을 이용하면 무리한 반복을 피하여 풀이한다.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("test");
        Solution solution = new Solution();
        String test = "cdcd";
        int result = solution.solution(test);
        System.out.println("결과 값: " + result);
    }

    public int solution(String s) {
        Stack<String> stack = new Stack<>();

        int result = -1;
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                String lastVal = stack.peek();
                String currVal = String.valueOf(s.charAt(i));
                if (!lastVal.equals(currVal)) {
                    stack.push(currVal);
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.size() == 0) {
            result = 1;
        } else {
            result = 0;
        }

        return result;
    }

    public int failSolution(String s) {
        int answer = -1;
        StringBuffer stringBuffer = new StringBuffer(s);
        int count = stringBuffer.length();
        for (int i = 0; i < count; i++) {
            if ((i + 1) != count) {
                if (stringBuffer.charAt(i) == stringBuffer.charAt(i + 1)) {
                    stringBuffer = stringBuffer.deleteCharAt(i + 1);
                    stringBuffer = stringBuffer.deleteCharAt(i);
                    count -= 2;
                    i = -1;
                    answer = 1;
                } else {
                    answer = 0;
                }
            }
        }
        return answer;
    }
}
