package programmers.Level1.solution._72_붕대_감기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250137
 */
public class Solution {

    public static void main(String[] args) {
        int[] bandage = { 5, 1, 5 };
        int health = 30;
        int[][] attacks = { { 2, 10 }, { 9, 15 }, { 10, 5 }, { 11, 5 } };
        int expectedResult = 5;

        Solution solution = new Solution();
        int result = solution.solution(bandage, health, attacks);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        int playTime = attacks[attacks.length - 1][0];
        int continueHealCount = 0;
        int attackCount = 0;
        int maxHp = health;

        for (int second = 0; second <= playTime; second++) {
            continueHealCount++;
            // 공격시간이 되면 공격
            if (attacks[attackCount][0] == second) {
                health -= attacks[attackCount][1];
                attackCount++;
                continueHealCount = 0;
            } else {
                health += bandage[1];
                // 연속 성공하면 에너지 차도록 조건 추가
                if (continueHealCount == bandage[0]) {
                    health += bandage[2];
                    continueHealCount = 0;
                }
            }

            // 피가 너무 많이 차면 풀피로 변경
            if (maxHp < health) {
                health = maxHp;
            }

            if (health <= 0) {
                return -1;
            }

        }
        return health;
    }

}
