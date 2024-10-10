package programmers.Level0.solution._93_외계행성의_나이;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120834?language=java
 */
class Solution {

    public static void main(String[] args) {
        int age = 23;
        String expectedResult = "cd";

        Solution solution = new Solution();
        String result = solution.solution(age);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(int age) {
        StringBuilder answer = new StringBuilder();
        while (0 < age) {
            int number = age % 10;
            char alphabet = (char) ('a' + number);
            answer.append(alphabet);
            age /= 10;
        }

        return answer.reverse().toString();
    }
}
