package programmers.Level0.solution._17_중복된_숫자_개수;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120583
 */
public class Solution {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 5};
        int n = 5;

        Solution solution = new Solution();
        int result = solution.solution(array, n);
        System.out.println("result: " + result);
    }

    public int solution(int[] array, int n) {
        int answer = 0;
        for (int number : array) {
            if (number == n) {
                answer++;
            }
        }
        return answer;
    }

}
