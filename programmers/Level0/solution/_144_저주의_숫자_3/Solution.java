package programmers.Level0.solution._144_저주의_숫자_3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120871?language=java
 */
class Solution {

    public static void main(String[] args) {
        int n = 15;
        int expectedResults = 25;

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
        for (int i = 1; i <= n; i++) {
            answer++;
            if (i % 3 == 0 || String.valueOf(i).contains("3")) {
                n++;
            }
        }
        return answer;
    }
}
