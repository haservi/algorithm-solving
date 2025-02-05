package programmers.Level0.solution._143_겹치는_선분의_길이;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120876?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[][] lines = { { 0, 1 }, { 2, 5 }, { 3, 9 } };
        int expectedResults = 2;

        Solution solution = new Solution();
        int result = solution.solution(lines);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[][] lines) {
        int answer = 0;

        int[] count = new int[201];

        for (int[] line : lines) {
            int start = line[0] + 100;
            int end = line[1] + 100;

            for (int k = start; k < end; k++) {
                count[k]++;
            }
        }

        for (int i : count) {
            if (i > 1) {
                answer++;
            }
        }

        return answer;
    }
}
