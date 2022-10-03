package programmers.Level0.solution._12_나이_출력;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120820
 */
public class Solution {

    public static void main(String[] args) {
        int age = 40;

        Solution solution = new Solution();
        int result = solution.solution(age);
        System.out.println("result: " + result);
    }

    public int solution(int age) {
        int answer = 2022 - age + 1;
        return answer;
    }

}
