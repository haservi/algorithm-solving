package programmers.Level0.solution._146_삼각형의_완성조건_2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120868?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] sides = { 11, 7 };
        int expectedResults = 13;

        Solution solution = new Solution();
        int result = solution.solution(sides);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] sides) {
        int answer = 0;
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);

        // max가 가장 긴 변인 경우
        for (int i = (max - min + 1); i <= max; i++) {
            answer++;
        }

        // 새로운 변이 가장 긴 변인 경우
        int sum = sides[0] + sides[1];
        for (int i = max + 1; i < sum; i++) {
            answer++;
        }

        return answer;
    }
}
