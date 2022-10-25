package programmers.Level0.solution._39_짝수_홀수_개수;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120824
 */
public class Solution {

    public static void main(String[] args) {
        int[] num_list = { 1, 2, 3, 4, 5 };

        Solution solution = new Solution();
        int[] result = solution.solution(num_list);
        System.out.println("result: " + Arrays.toString(result));
    }

    public int[] solution(int[] num_list) {
        int[] answer = new int[2];

        for (int number : num_list) {
            if (number % 2 == 0)
                answer[0]++;
            else
                answer[1]++;
        }
        return answer;
    }

}
