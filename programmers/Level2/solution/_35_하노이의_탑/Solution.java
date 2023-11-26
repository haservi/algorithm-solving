package programmers.Level2.solution._35_하노이의_탑;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/68936
 */
public class Solution {

    public static void main(String[] args) {
        int n = 7;
        int[][] expectedResult = { { 1, 2 }, { 1, 3 }, { 2, 3 } };

        Solution solution = new Solution();
        int[][] result = solution.solution2(n);

        if (Arrays.deepEquals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[][] solution(int n) {
        return hanoi(n, 1, 3).toArray(new int[0][]);
    }

    private List<int[]> hanoi(int n, int from, int to) {
        if (n == 1) {
            return List.of(new int[] { from, to });
        }

        int empty = 6 - from - to;

        List<int[]> result = new ArrayList<>();
        result.addAll(hanoi(n - 1, from, empty));
        result.addAll(hanoi(1, from, to));
        result.addAll(hanoi(n - 1, empty, to));
        return result;
    }

    public int[][] solution2(int n) {
        List<int[]> process = new ArrayList<>();
        hanoi(n, 1, 3, process);
        return process.toArray(new int[0][]);
    }

    private void hanoi(int n, int from, int to, List<int[]> process) {
        if (n == 1) {
            process.add(new int[] { from, to });
            return;
        }

        int empty = 6 - from - to;

        hanoi(n - 1, from, empty, process);
        hanoi(1, from, to, process);
        hanoi(n - 1, empty, to, process);
    }
}
