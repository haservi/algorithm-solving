package programmers.Level0.solution._32_분수의_덧셈;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120808?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int denum1 = 9;
        int num1 = 2;
        int denum2 = 1;
        int num2 = 3;

        Solution solution = new Solution();
        int[] result = solution.solution(denum1, num1, denum2, num2);
        System.out.println("result: " + Arrays.toString(result));
    }
    
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int[] answer = new int[2];
        int denum = (denum1 * num2) + (denum2 * num1);
        int num = num1 * num2;

        int gcd = getGcd(denum, num);
        answer[0] = denum / gcd;
        answer[1] = num / gcd;
        return answer;
    }

    private int getGcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGcd(num2, (num1 % num2));
    }
}
