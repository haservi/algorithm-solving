package programmers.Level0.solution._162_뒤에서_5등까지;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181853?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] num_list = { 12, 4, 15, 46, 38, 1, 14 };
        int[] expectedResult = { 1, 4, 12, 14, 15 };

        Solution solution = new Solution();
        int[] result = solution.solution(num_list);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        return Arrays.copyOfRange(num_list, 0, 5);
    }
}
