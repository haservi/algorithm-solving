package baekjoon.problem._014_괄호의_값;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/2504
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(solution(input));
    }

    public static int solution(String input) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int value = 1;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '(': {
                    stack.push(ch);
                    value *= 2;
                    break;
                }
                case '[': {

                    stack.push(ch);
                    value *= 3;
                    break;
                }
                case ')': {

                    if (stack.isEmpty() || stack.peek() != '(') {
                        return 0;
                    }
                    if (input.charAt(i - 1) == '(') {
                        result += value;
                    }
                    stack.pop();
                    value /= 2;
                    break;
                }
                case ']': {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return 0;
                    }
                    if (input.charAt(i - 1) == '[') {
                        result += value;
                    }
                    stack.pop();
                    value /= 3;
                    break;
                }
            }
        }
        return stack.isEmpty() ? result : 0;
    }

}
