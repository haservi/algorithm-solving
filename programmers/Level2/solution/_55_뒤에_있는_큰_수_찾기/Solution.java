package programmers.Level2.solution._55_뒤에_있는_큰_수_찾기;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[] numbers = { 2, 3, 3, 5 };
        int[] expectedResult = { 3, 5, 5, -1 };

        Solution solution = new Solution();
        int[] result = solution.solution1(numbers);

        if (Arrays.equals(result, expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(numbers[i]);
        }

        return answer;
    }

}
