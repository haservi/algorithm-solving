package baekjoon.problem._013_괄호_제거;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/2800
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Set<String> results = solution(input);
        List<String> sortedResults = new ArrayList<>(results);
        sortedResults.sort(String::compareTo);

        sortedResults.stream().forEach(System.out::println);
    }

    static class Pair {
        int open;
        int close;

        Pair(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }

    public static Set<String> solution(String input) {
        List<Pair> pairs = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        // 괄호 쌍 찾기
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else if (input.charAt(i) == ')') {
                pairs.add(new Pair(stack.pop(), i));
            }
        }

        Set<String> results = new HashSet<>();
        findCombinations(input, pairs, 0, new boolean[input.length()], results);
        results.remove(input); // 원본 문자열 제거

        return results;
    }

    private static void findCombinations(String input, List<Pair> pairs, int index, boolean[] toRemove,
            Set<String> results) {
        if (index == pairs.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                if (!toRemove[i]) {
                    sb.append(input.charAt(i));
                }
            }
            System.out.println(sb.toString());
            results.add(sb.toString());
            return;
        }

        Pair pair = pairs.get(index);
        toRemove[pair.open] = true;
        toRemove[pair.close] = true;
        findCombinations(input, pairs, index + 1, toRemove, results);

        toRemove[pair.open] = false;
        toRemove[pair.close] = false;
        findCombinations(input, pairs, index + 1, toRemove, results);
    }
}
