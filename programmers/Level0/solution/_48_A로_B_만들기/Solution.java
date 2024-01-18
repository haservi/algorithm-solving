package programmers.Level0.solution._48_A로_B_만들기;

import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120886
 */
public class Solution {

    public static void main(String[] args) {
        String before = "olleh";
        String after = "hello";
        int expectedResult = 1;

        Solution solution = new Solution();
        int result = solution.solution(before, after);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String before, String after) {
        return toMap(before).equals(toMap(after)) ? 1 : 0;
    }

    private HashMap<Character, Integer> toMap(String word) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : word.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        return map;
    }
}
