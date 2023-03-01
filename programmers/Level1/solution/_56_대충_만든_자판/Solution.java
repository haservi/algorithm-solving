package programmers.Level1.solution._56_대충_만든_자판;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String[] keyMap = { "ABACD", "BCEFD" };
        String[] targets = { "ABCD", "AABB" };
        Solution solution = new Solution();
        int[] result = solution.solution(keyMap, targets);
        System.out.println("result: " + Arrays.toString(result));
    }

    public int[] solution(String[] keyMap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> move = new HashMap<>(64);

        for (String key : keyMap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int step = move.getOrDefault(c, i + 1);
                move.put(c, Math.min(step, i + 1));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int distance = 0;
            String target = targets[i];
            for (int j = 0; j < target.length(); j++) {
                char t = target.charAt(j);
                if (move.containsKey(t)) {
                    distance += move.get(t);
                } else {
                    distance = -1;
                    break;
                }
            }
            answer[i] = distance;
        }

        return answer;
    }
}
