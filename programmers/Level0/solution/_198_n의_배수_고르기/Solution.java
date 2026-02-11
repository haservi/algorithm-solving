package programmers.Level0.solution._198_n의_배수_고르기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120905?language=java">...</a>
 */
class Solution {

    public static void main(String[] args) {
        int n = 3;
        int[] numlist = {4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] expectedResult = {6, 9, 12};

        Solution solution = new Solution();
        int[] result = solution.solution(n, numlist);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int n, int[] numlist) {
        List<Integer> result = new ArrayList<>();

        for (int num : numlist) {
            if (num % n == 0) {
                result.add(num);
            }
        }

        return result.stream()
                .mapToInt(i -> i)
                .toArray();
    }

}
