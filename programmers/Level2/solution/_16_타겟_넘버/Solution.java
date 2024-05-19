package programmers.Level2.solution._16_타겟_넘버;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java
 */
public class Solution {
    public static void main(String[] args) {
        int[] numbers = { 4, 1, 2, 1 };
        int target = 4;
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution1(numbers, target);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] numbers, int target) {
        int answer = dfs(0, 0, numbers, target);
        return answer;
    }

    private int dfs(int sum, int depth, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int plusSum = sum + numbers[depth];
        int minusSum = sum - numbers[depth];

        return dfs(plusSum, depth + 1, numbers, target) + dfs(minusSum, depth + 1, numbers, target);
    }

    public int solution1(int[] numbers, int target) {
        Stack<State> stateStack = new Stack<>();
        stateStack.push(new State(0, 0));

        int count = 0;

        while (!stateStack.isEmpty()) {
            State state = stateStack.pop();

            if (state.index == numbers.length) {
                if (state.acc == target)
                    count++;
                continue;
            }

            stateStack.push(new State(state.index + 1, state.acc - numbers[state.index]));
            stateStack.push(new State(state.index + 1, state.acc + numbers[state.index]));
        }

        return count;
    }

    private static class State {
        private final int index;
        private final int acc;

        private State(int index, int acc) {
            this.index = index;
            this.acc = acc;
        }
    }
}
