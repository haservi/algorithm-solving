package programmers.Level2.solution._42_스킬트리;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49993?language=java
 */
public class Solution {

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTrees = { "BACDE", "CBADF", "AECB", "BDA" };
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution(skill, skillTrees);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }

    public int solution(String skill, String[] skillTrees) {
        return (int) Arrays.stream(skillTrees)
                .map(s -> s.replaceAll("[^" + skill + "]", ""))
                .filter(skill::startsWith)
                .count();
    }

}
