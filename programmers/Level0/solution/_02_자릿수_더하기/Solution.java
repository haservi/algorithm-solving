package programmers.Level0.solution._02_자릿수_더하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120906
 */
public class Solution {

    public static void main(String[] args) {

        int n = 1234;

        Solution solution = new Solution();
        int result = solution.solution(n);
        System.out.println("result: " + result);

    }

    public int solution(int n) {
        int answer = 0;
        while (n != 0) {
            answer += (n % 10);
            n /= 10;
        }
        return answer;
    }
}
