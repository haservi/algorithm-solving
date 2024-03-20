package programmers.Level2.solution._19_올바른_괄호;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class Solution {

    public static void main(String[] args) {

        String s = "(()(";
        boolean expectedResult = false;

        Solution solution = new Solution();
        boolean result = solution.solution(s);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public boolean solution(String s) {
        // 시작이 '('로 시작하지 않으면 실패
        if (s.charAt(0) != '(') {
            return false;
        }

        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                charStack.add(s.charAt(i));
            } else {
                // 항목이 없다면 실패
                if (charStack.isEmpty()) {
                    return false;
                } else {
                    charStack.pop();
                }
            }
        }
        if (!charStack.isEmpty())
            return false;

        return true;
    }

    public boolean solution1(String s) {
        int counter = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> counter++;
                case ')' -> {
                    if (counter-- == 0) {
                        return false;
                    }
                }
            }
        }

        return counter == 0;
    }

}
