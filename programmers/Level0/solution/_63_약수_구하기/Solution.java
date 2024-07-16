package programmers.Level0.solution._63_약수_구하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120897?language=java
 */
class Solution {

    public static void main(String[] args) {
        int n = 24;
        int[] expectedResult = { 1, 2, 3, 4, 6, 8, 12, 24 };

        Solution solution = new Solution();
        int[] result = solution.solution(n);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer.add(i);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
