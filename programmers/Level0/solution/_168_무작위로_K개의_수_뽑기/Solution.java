package programmers.Level0.solution._168_무작위로_K개의_수_뽑기;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181858?language=java?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 1, 2, 2, 3 };
        int k = 3;
        int[] expectedResult = { 0, 1, 2 };

        Solution solution = new Solution();
        int[] result = solution.solution(arr, k);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr, int k) {
        Set<Integer> unique = new LinkedHashSet<>();
        for (int num : arr) {
            unique.add(num);
        }

        int[] answer = new int[k];
        Arrays.fill(answer, -1);

        int i = 0;
        for (int num : unique) {
            if (i >= k) {
                break;
            }
            answer[i++] = num;
        }

        return answer;
    }

}
