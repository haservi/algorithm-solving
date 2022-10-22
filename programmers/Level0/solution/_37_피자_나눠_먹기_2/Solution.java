package programmers.Level0.solution._37_피자_나눠_먹기_2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120815
 */
public class Solution {

    public static void main(String[] args) {
        int n = 10;

        Solution solution = new Solution();
        int result = solution.solution(n);
        System.out.println("result: " + result);
    }

    public int solution(int n) {
        int answer = lcm(n, 6) / 6;
        return answer;
    }

    /**
     * 최대 공약수(Greatest Common Factor)
     */
    private int gcd(int num1, int num2) {
        if (num2 == 0)
            return num1;
        return gcd(num2, num1 % num2);
    }

    /**
     * 최소 공배수(Least Common Multiple)
     */
    private int lcm(int num1, int num2) {
        return num1 * num2 / gcd(num1, num2);
    }
}
