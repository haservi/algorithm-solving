package programmers.Level0.solution._96_진료순서_정하기;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120835?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] emergency = { 3, 76, 24 };
        int[] expectedResult = { 3, 1, 2 };

        Solution solution = new Solution();
        int[] result = solution.solution(emergency);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] emergency) {
        int[] clone = emergency.clone();
        Arrays.sort(clone);

        HashMap<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < clone.length; i++) {
            rankMap.put(clone[i], clone.length - i);
        }

        int[] answer = new int[emergency.length];
        for (int i = 0; i < emergency.length; i++) {
            answer[i] = rankMap.get(emergency[i]);
        }
        return answer;
    }
}
