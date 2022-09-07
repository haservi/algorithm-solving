package programmers.Level1.solution._49_x만큼_간격이_있는_n개의_숫자;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12954
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long[] result = solution.solution(2, 5);
        System.out.println("result: " + Arrays.toString(result));
    }

    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (long) x * (i + 1);
        }
        return answer;
    }
}
