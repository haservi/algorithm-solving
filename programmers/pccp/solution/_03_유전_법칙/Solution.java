package programmers.pccp.solution._03_유전_법칙;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/15008/lessons/121685?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[][] queries = { { 3, 5 } };
        String[] expectedResult = { "RR" };

        Solution solution = new Solution();
        String[] result = solution.solution(queries);

        if (Arrays.equals(result, expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(int[][] queries) {
        return Arrays.stream(queries)
                .map(query -> find(query[0], query[1] - 1))
                .toArray(String[]::new);
    }

    private String find(int n, int p) {
        if (n == 1) {
            return "Rr";
        }

        int slice = (int) Math.pow(4, n - 2);
        int group = p / slice;

        if (group == 0) {
            return "RR";
        }
        if (group == 3) {
            return "rr";
        }

        return find(n - 1, p % slice);
    }
}
