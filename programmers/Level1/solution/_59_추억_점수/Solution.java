package programmers.Level1.solution._59_추억_점수;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println("test");
        String[] name = { "may", "kein", "kain", "radi" };
        int[] yearning = { 5, 10, 1, 3 };
        String[][] photo = {
                { "may", "kein", "kain", "radi" },
                { "may", "kein", "brin", "deny" },
                { "kon", "kain", "may", "coni" }
        };
        int[] expectResult = { 19, 15, 6 };

        Solution solution = new Solution();
        int[] result = solution.solution(name, yearning, photo);

        if (Arrays.equals(result, expectResult)) {
            System.out.println("Test Pass 😆");
        } else {
            System.out.println("Test Fail 😭");
        }

    }

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> nameScoreMap = new HashMap<String, Integer>();

        // name과 yearning 점수를 매칭
        for (int i = 0; i < name.length; i++) {
            nameScoreMap.put(name[i], yearning[i]);
        }

        // 사진을 돌면서 해당 이름과 일치하는 점수 계산
        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (int j = 0; j < photo[i].length; j++) {
                String currentName = photo[i][j];
                if (nameScoreMap.containsKey(currentName)) {
                    score += nameScoreMap.get(currentName);
                }
            }
            answer[i] = score;
        }

        return answer;
    }
}
