package programmers.Level0.solution._11_숫자_비교하기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120807
 */
public class Solution {

    public static void main(String[] args) {
        int num1 = 2;
        int num2 = 3;

        Solution solution = new Solution();
        int result = solution.solution(num1, num2);
        System.out.println("result: " + result);
    }

    public int solution(int num1, int num2) {
        if (num1 == num2)
            return 1;
        return -1;
    }

}
