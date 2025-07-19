package programmers.Level0.solution._167_배열_만들기_6;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181859?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 1, 1, 0 };
        int[] expectedResult = { 0, 1, 0 };

        Solution solution = new Solution();
        int[] result = solution.solution(arr);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stk.isEmpty()) {
                stk.push(arr[i]);
            } else if (stk.peek() == arr[i]) {
                stk.pop();
            } else {
                stk.push(arr[i]);
            }
        }

        if (stk.isEmpty()) {
            return new int[] { -1 };
        }

        int[] result = new int[stk.size()];
        for (int j = 0; j < result.length; j++) {
            result[j] = stk.get(j);
        }

        return result;
    }
}
