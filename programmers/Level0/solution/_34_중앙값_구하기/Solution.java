package programmers.Level0.solution._34_중앙값_구하기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120811
 */
public class Solution {
    
    public static void main(String[] args) {
        int[] array = {1, 2, 7, 10, 11};

        Solution solution = new Solution();
        int result = solution.solution(array);
        System.out.println("result: " + result);
    }

    public int solution(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }
}
