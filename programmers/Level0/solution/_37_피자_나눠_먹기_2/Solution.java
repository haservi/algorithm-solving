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
     * 최대 공약수
     */
    private int gdc(int num1, int num2) {
        if (num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        while (num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return num1;
    }

    /**
     * 최소 공배수
     */
    private int lcm(int num1, int num2) {
        return num1 * num2 / gdc(num1, num2);
    }
}
