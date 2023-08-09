package programmers.Level1.solution._61_가장_가까운_같은_글자;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String s = "banana";
        int[] expectedResult = { -1, -1, -1, 2, 2, 2 };

        Solution solution = new Solution();
        int[] result = solution.solution(s);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> keyMap = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            if (!keyMap.containsKey(s.charAt(i))) {
                answer[i] = -1;
            } else {
                answer[i] = i - keyMap.get(s.charAt(i));
            }
            keyMap.put(s.charAt(i), i);
        }
        return answer;
    }

}
