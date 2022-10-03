package programmers.Level0.solution._13_배열의_평균값;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120817
 */
public class Solution {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Solution solution = new Solution();
        double result = solution.solution(numbers);
        System.out.println("result: " + result);
    }

    public double solution(int[] numbers) {
        double answer = 0;

        for (int number : numbers) {
            answer += number;
        }
        answer /= numbers.length;

        return answer;
    }
}
