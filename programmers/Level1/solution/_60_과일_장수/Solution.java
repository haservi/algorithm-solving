package programmers.Level1.solution._60_과일_장수;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int k = 3;
        int m = 4;
        int[] score = { 1, 2, 3, 1, 2, 3, 1 };
        int expectedResult = 8;

        Solution solution = new Solution();
        int result = solution.solution(k, m, score);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int k, int m, int[] score) {

        int answer = 0;
        Arrays.sort(score);
        int count = score.length;

        int index = count - m;
        while (0 <= index) {
            answer += (score[index] * m);
            index -= m;
        }

        return answer;
    }

}
