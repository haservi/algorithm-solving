package programmers.Level0.solution._33_아이스_아메리카노;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120819
 */
public class Solution {

    public static void main(String[] args) {
        int money = 15000;

        Solution solution = new Solution();
        int[] result = solution.solution(money);
        System.out.println("result: " + Arrays.toString(result));
    }

    private final int ICE_AMERICANO = 5500;

    public int[] solution(int money) {
        int[] answer = new int[2];
        answer[0] = money / ICE_AMERICANO;
        answer[1] = money % ICE_AMERICANO;
        return answer;
    }

}
