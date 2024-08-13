package programmers.Level2.solution._64_연속_부분_수열_합의_개수;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int n = 100;
        String expectedResult = "24";

        Solution solution = new Solution();
        String result = solution.solution(n);

        if (result.equals(expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int value = n % 3;
            if (value == 0) {
                sb.append(4);
                n = (n / 3) - 1;
            } else {
                sb.append(value);
                n /= 3;
            }
        }
        return sb.reverse().toString();
    }
}
