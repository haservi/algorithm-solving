package programmers.Level0.solution._123_개미_군단;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120837?language=java
 */
class Solution {

    public static void main(String[] args) {
        int hp = 23;
        int expectedResult = 5;

        Solution solution = new Solution();
        int result = solution.solution(hp);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int hp) {
        int answer = (hp / 5);
        hp = hp % 5;

        answer += (hp / 3);
        hp = hp % 3;

        answer += (hp / 1);

        return answer;
    }

}
