package programmers.Level2.solution._46_양궁대회;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92342?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int n = 5;
        int[] info = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
        int[] expectedResult = { 0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0 };

        Solution solution = new Solution();
        int[] result = solution.solution(n, info);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int n, int[] info) {
        int[] answer = ryan(0, new int[11], n, info);
        if (answer == null) {
            return new int[] { -1 };
        }
        return answer;
    }

    private int[] ryan(int index, int[] hits, int n, int[] apeach) {
        if (hits.length == index) {
            // 남은 화살이 있는 경우
            if (0 < n) {
                return null;
            }
            // 어피치가 스코어가 더 높은 경우
            if (scoreDiff(apeach, hits) <= 0) {
                return null;
            }
            return Arrays.copyOf(hits, hits.length);
        }

        int maxDiff = 0;
        int[] result = null;

        // 현재 과녁에 쏠 화살의 개수를 0부터 n까지 시도
        for (int hit = 0; hit <= n; hit++) {
            hits[index] = hit;
            int[] ryan = ryan(index + 1, hits, n - hit, apeach);
            if (ryan == null) {
                continue;
            }

            int diff = scoreDiff(apeach, ryan);
            if (maxDiff < diff || (diff == maxDiff && isPrior(result, ryan))) {
                maxDiff = diff;
                result = ryan;
            }
        }

        return result;
    }

    private int scoreDiff(int[] apeach, int[] ryan) {
        int diff = 0;
        for (int i = 0; i < apeach.length; i++) {
            // 둘 다 맞추지 못한 경우는 무시
            if (apeach[i] == 0 && ryan[i] == 0) {
                continue;
            }
            // 어피치가 이기거나 점수가 같은 경우
            if (apeach[i] >= ryan[i]) {
                diff -= 10 - i;
            } else { // 라이언이 이긴 경우
                diff += 10 - i;
            }
        }
        return diff;
    }

    private boolean isPrior(int[] base, int[] comp) {
        for (int i = 10; i >= 0; i--) {
            if (comp[i] == base[i]) {
                continue;
            }
            return comp[i] > base[i];
        }
        return false;
    }

}
