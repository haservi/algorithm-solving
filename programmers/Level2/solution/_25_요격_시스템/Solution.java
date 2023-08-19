package programmers.Level2.solution._25_요격_시스템;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[][] targets = {
                { 4, 5 }, { 4, 8 }, { 10, 14 }, { 11, 13 }, { 5, 12 }, { 3, 7 }, { 1, 4 }
        };
        int expectedResult = 3;

        Solution solution = new Solution();
        int result = solution.solution(targets);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[][] targets) {
        int answer = 0;

        // 미사일 도착 순으로 정렬
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int end = targets[0][1];
        answer++;

        for (int[] target : targets) {
            // System.out.println(Arrays.toString(target));
            if (end <= target[0]) {
                end = target[1];
                answer++;
            }
        }

        return answer;
    }
}
