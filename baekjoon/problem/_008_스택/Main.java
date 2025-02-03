package baekjoon.problem._008_스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/10828
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            solution(stack, input, sb);
        }

        System.out.print(sb.toString());
    }

    private static void solution(List<Integer> stack, String input, StringBuilder sb) {
        String[] parts = input.split(" ");
        String command = parts[0];

        switch (command) {
            case "push":
                int value = Integer.parseInt(parts[1]);
                push(stack, value);
                break;
            case "pop":
                sb.append(pop(stack)).append('\n');
                break;
            case "top":
                sb.append(top(stack)).append('\n');
                break;
            case "size":
                sb.append(size(stack)).append('\n');
                break;
            case "empty":
                sb.append(empty(stack)).append('\n');
                break;
            default:
                break;
        }
    }

    private static void push(List<Integer> stack, int value) {
        stack.add(value);
    }

    private static int pop(List<Integer> stack) {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.remove(stack.size() - 1);
    }

    private static int top(List<Integer> stack) {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.get(stack.size() - 1);
    }

    private static int size(List<Integer> stack) {
        return stack.size();
    }

    private static int empty(List<Integer> stack) {
        return stack.isEmpty() ? 1 : 0;
    }
}
