package programmers.Level0.solution._28_배열_뒤집기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120821
 */
public class Solution {

    public static void main(String[] args) {
        int[] num_list = { 1, 2, 3, 4, 5 };

        Solution solution = new Solution();
        int[] result = solution.solution(num_list);
        System.out.println("result: " + Arrays.toString(result));

    }

    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        int index = num_list.length;
        for (int num : num_list) {
            answer[--index] = num;
        }
        return answer;
    }

}
