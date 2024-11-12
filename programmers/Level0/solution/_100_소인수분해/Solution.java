package programmers.Level0.solution._100_소인수분해;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120852?language=java
 */
class Solution {

    public static void main(String[] args) {
        int n = 12;
        int[] expectedResult = { 2, 3 };

        Solution solution = new Solution();
        int[] result = solution.solution(n);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int n) {
        List<Integer> factors = new ArrayList<>();
        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            while (n % i == 0) {
                n /= i;
                if (!factors.contains(i)) {
                    factors.add(i);
                }
            }
        }

        if (n > 1) {
            factors.add(n);
        }

        return factors.stream().mapToInt(Integer::intValue).toArray();
    }
}
