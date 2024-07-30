package programmers.Level2.solution._63_124_나라의_숫자;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12899?language=java
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
