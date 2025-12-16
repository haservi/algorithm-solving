package programmers.Level0.solution._183_뒤에서_5등_위로;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181852?language=java
 *
 */
class Solution {

    public static void main(String[] args) {

        int[] num_list = { 12, 4, 15, 46, 38, 1, 14, 56, 32, 10 };
        int[] expectedResult = { 15, 32, 38, 46, 56 };

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
        return Arrays.copyOfRange(num_list, 5, num_list.length);
    }

}
