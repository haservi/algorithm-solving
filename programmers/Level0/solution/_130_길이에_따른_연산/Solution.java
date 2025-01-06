package programmers.Level0.solution._130_길이에_따른_연산;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181879?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] num_list = { 2, 3, 4, 5 };
        int expectedResults = 120;

        Solution solution = new Solution();
        int result = solution.solution(num_list);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] num_list) {
        if (num_list.length <= 10) {
            // 리스트 항목의 모든 곱을 반환
            return Arrays.stream(num_list).reduce(1, (a, b) -> a * b);
        } else {
            // 리스트 항목의 모든 합을 반환
            return Arrays.stream(num_list).sum();
        }
    }

}
