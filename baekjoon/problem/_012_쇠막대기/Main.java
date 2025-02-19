package baekjoon.problem._012_쇠막대기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/10799
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(solution(input));
    }

    public static int solution(String input) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
                if (input.charAt(i - 1) == '(') {
                    // 레이저인 경우
                    count += stack.size();
                } else {
                    // 쇠막대기의 끝인 경우
                    count += 1;
                }
            }
        }

        return count;
    }
}
