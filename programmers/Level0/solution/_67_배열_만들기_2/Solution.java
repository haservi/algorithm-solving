package programmers.Level0.solution._67_배열_만들기_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181921?language=java
 */
class Solution {

    public static void main(String[] args) {
        int l = 5;
        int r = 55;
        int[] expectedResult = { 5, 50, 55 };

        Solution solution = new Solution();
        int[] result = solution.solution(l, r);
        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            if (containsOnlyZeroAndFive(i)) {
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            return new int[] { -1 };
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean containsOnlyZeroAndFive(int num) {
        while (num > 0) {
            int digit = num % 10;
            if (digit != 0 && digit != 5) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
