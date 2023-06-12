package programmers.Level1.solution._58_달리기_경주;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        String[] players = { "mumu", "soe", "poe", "kai", "mine" };
        String[] callings = { "kai", "kai", "mine", "mine" };
        String[] expectResult = { "mumu", "kai", "mine", "soe", "poe" };

        Solution solution = new Solution();
        String[] result = solution.solution(players, callings);

        if (Arrays.equals(result, expectResult)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerIndexMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerIndexMap.put(players[i], i);
        }

        for (String calling : callings) {
            if (playerIndexMap.containsKey(calling)) {
                int playerIndex = playerIndexMap.get(calling);

                if (playerIndex > 0) {
                    String temp = players[playerIndex - 1];
                    players[playerIndex - 1] = players[playerIndex];
                    players[playerIndex] = temp;
                    playerIndexMap.put(players[playerIndex - 1], playerIndex - 1);
                    playerIndexMap.put(players[playerIndex], playerIndex);
                }
            }

        }

        return players;
    }
}
