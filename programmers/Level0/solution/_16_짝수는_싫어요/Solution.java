package programmers.Level0.solution._16_짝수는_싫어요;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120813
 */
public class Solution {

    public static void main(String[] args) {
        int n = 15;

        Solution solution = new Solution();
        int[] result = solution.solution(n);
        System.out.println("result: " + Arrays.toString(result));
    }

    public int[] solution(int n) {
        int count = (n + 1) / 2;
        int[] answer = new int[count];

        int number = 1;
        for (int i = 0; i < count; i++) {
            answer[i] = number;
            number += 2;
        }

        return answer;
    }

}
