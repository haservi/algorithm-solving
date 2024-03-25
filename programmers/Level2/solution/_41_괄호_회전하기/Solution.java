package programmers.Level2.solution._41_괄호_회전하기;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502?language=java
 */
public class Solution {

    public static void main(String[] args) {
        String s = "[](){}";
        int expectedResult = 3;

        Solution solution = new Solution();
        int result = solution.solution(s);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }

    public int solution(String s) {
        char[] str = s.toCharArray();

        int count = 0;
        for (int offset = 0; offset < str.length; offset++) {
            if (isCorrect(str, offset)) {
                count++;
            }
        }
        return count;
    }

    private boolean isCorrect(char[] str, int offset) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            char c = str[(offset + i) % str.length];
            switch (c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                case ')', '}', ']' -> {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop() != c) {
                        return false;
                    }
                }

            }
        }
        return stack.isEmpty();
    }

}
