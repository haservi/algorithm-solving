package programmers.Level4.solution._02_사칙연산;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1843
 */
public class Solution {

    public static void main(String[] args) {
        String[] arr = { "5", "-", "3", "+", "1", "+", "2", "-", "4" };
        int expectedResult = 3;

        Solution solution = new Solution();
        int result = solution.solution(arr);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String arr[]) {
        for (int[][] m : mem) {
            for (int[] row : m) {
                // 메모이제이션을 위해 모든 값을 초기화
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        return compute(0, arr.length, 0, arr);
    }

    private interface IntComparator extends Comparator<Integer> {
    };

    private static final IntComparator[] COMP = {
            (a, b) -> Integer.compare(a, b), (a, b) -> Integer.compare(b, a),
    };
    private static final int[] INIT = {
            Integer.MIN_VALUE, Integer.MAX_VALUE,
    };
    private final int[][][] mem = new int[202][202][2];

    private int compute(int start, int end, int type, String[] arr) {
        if (mem[start][end][type] != Integer.MIN_VALUE) {
            return mem[start][end][type];
        }
        if (end - start == 1) {
            return Integer.parseInt(arr[start]);
        }

        int result = INIT[type];
        for (int i = start + 1; i < end; i += 2) {
            int left = compute(start, i, type, arr);
            int value;
            if (arr[i].equals("+")) {
                int right = compute(i + 1, end, type, arr);
                value = left + right;
            } else {
                int right = compute(i + 1, end, 1 - type, arr);
                value = left - right;
            }
            if (COMP[type].compare(value, result) > 0) {
                result = value;
            }
        }
        return mem[start][end][type] = result;
    }
}
