package programmers.Level2.solution._30_광물_캐기;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] picks = { 0, 1, 1 };
        String[] minerals = { "diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron",
                "iron", "diamond" };
        int expected = 50;

        Solution solution = new Solution();
        int result = solution.solution(picks, minerals);

        if (result == expected) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    private static final int CRASH_COUNT = 5;

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int count = Math.min((minerals.length / CRASH_COUNT) + 1, picks[0] + picks[1] + picks[2]);
        int[][] sections = new int[count][3];

        int diamondCount = 0;
        int ironCount = 0;
        int stoneCount = 0;

        for (int i = 0; i < minerals.length; i += CRASH_COUNT) {
            if (i / CRASH_COUNT == count) {
                break;
            }

            for (int j = i; j < i + CRASH_COUNT; j++) {
                String mineral = minerals[j];
                if (mineral.equals("diamond")) {
                    diamondCount += 1;
                    ironCount += 5;
                    stoneCount += 25;
                } else if (mineral.equals("iron")) {
                    diamondCount += 1;
                    ironCount += 1;
                    stoneCount += 5;
                } else if (mineral.equals("stone")) {
                    diamondCount += 1;
                    ironCount += 1;
                    stoneCount += 1;
                }

                if (j == minerals.length - 1) {
                    break;
                }
            }
            sections[i / CRASH_COUNT][0] = diamondCount;
            sections[i / CRASH_COUNT][1] = ironCount;
            sections[i / CRASH_COUNT][2] = stoneCount;

            diamondCount = 0;
            ironCount = 0;
            stoneCount = 0;
        }

        // stone을 기준으로 내림 차순
        Arrays.sort(sections, (o1, o2) -> (o2[2] - o1[2]));

        for (int i = 0; i < count; i++) {
            if (picks[0] != 0) {
                answer += sections[i][0];
                picks[0]--;
            } else if (picks[1] != 0) {
                answer += sections[i][1];
                picks[1]--;
            } else if (picks[2] != 0) {
                answer += sections[i][2];
                picks[2]--;
            }
        }

        return answer;

    }

}
