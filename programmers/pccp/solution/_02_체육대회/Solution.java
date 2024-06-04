package programmers.pccp.solution._02_체육대회;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/15008/lessons/121684?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[][] ability = { { 40, 10, 10 }, { 20, 5, 0 }, { 30, 30, 30 }, { 70, 0, 70 }, { 100, 100, 100 } };
        int expectedResult = 210;

        Solution solution = new Solution();
        int result = solution.solution(ability);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private final Map<String, Integer> mem = new HashMap<>();

    public int solution(int[][] ability) {
        return max(0, new boolean[ability.length], ability);
    }

    private int max(int student, boolean[] isChosen, int[][] ability) {
        if (student == ability.length) {
            return 0;
        }

        String memKey = toString(student, isChosen);
        if (mem.containsKey(memKey)) {
            return mem.get(memKey);
        }

        int max = max(student + 1, isChosen, ability);

        for (int i = 0; i < ability[student].length; i++) {
            if (isChosen[i]) {
                continue;
            }
            isChosen[i] = true;
            int score = max(student + 1, isChosen, ability) + ability[student][i];
            if (max < score) {
                max = score;
            }
            isChosen[i] = false;
        }

        mem.put(memKey, max);
        return max;
    }

    private String toString(int student, boolean[] isChosen) {
        return student + Arrays.toString(isChosen);
    }
}
