package programmers.Level0.solution._31_피자_나눠_먹기_3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120816
 */
public class Solution {

    public static void main(String[] args) {
        int slice = 7;
        int n = 10;

        Solution solution = new Solution();
        int result = solution.solution(slice, n);
        System.out.println("result: " + result);
    }

    public int solution(int slice, int n) {
        return ((n - 1) / slice) + 1;
    }
}
