package programmers.Level2.solution._67_퍼즐_게임_챌린지;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/340212?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[] diffs = { 1, 5, 3 };
        int[] times = { 2, 4, 7 };
        long limit = 30;
        int expectedResult = 3;

        Solution solution = new Solution();
        int result = solution.solution(diffs, times, limit);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 1000000;
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canSolveAllPuzzles(diffs, times, limit, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    private boolean canSolveAllPuzzles(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0;
        int previousTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int timeCur = times[i];

            if (diff <= level) {
                totalTime += timeCur;
            } else {
                int mistakes = diff - level;
                totalTime += mistakes * (timeCur + previousTime) + timeCur;
            }

            if (totalTime > limit) {
                return false;
            }

            previousTime = timeCur;
        }

        return true;
    }

}
