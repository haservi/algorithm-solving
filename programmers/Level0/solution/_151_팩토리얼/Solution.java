package programmers.Level0.solution._151_팩토리얼;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120848?language=java
 */
class Solution {

    public static void main(String[] args) {
        int n = 3628800;
        int expectedResults = 10;

        Solution solution = new Solution();
        int result = solution.solution(n);

        if (expectedResults == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int n) {
        int answer = 0;
        long factorial = 1;
        while (factorial * (answer + 1) <= n) {
            factorial = factorial * (answer + 1);
            answer++;
        }
        return answer;
    }

}
