package programmers.Level0.solution._145_외계어_사전;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120869?language=java
 */
class Solution {

    public static void main(String[] args) {
        String[] spell = { "p", "o", "s" };
        String[] dic = { "sod", "eocd", "qixm", "adio", "soo" };
        int expectedResults = 2;

        Solution solution = new Solution();
        int result = solution.solution(spell, dic);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(String[] spells, String[] dics) {
        for (String dic : dics) {
            boolean isPassed = true;
            for (String spell : spells) {
                if (!dic.contains(spell)) {
                    isPassed = false;
                    break;
                }
            }
            if (isPassed) {
                return 1;
            }
        }
        return 2;
    }

    public int solution2(String[] spells, String[] dics) {
        Set<Character> spellSet = new HashSet<>();
        for (String spell : spells) {
            spellSet.add(spell.charAt(0));
        }

        for (String dic : dics) {
            Set<Character> dicSet = new HashSet<>();
            for (char ch : dic.toCharArray()) {
                dicSet.add(ch);
            }

            if (dicSet.containsAll(spellSet)) {
                return 1;
            }
        }
        return 2;
    }
}
