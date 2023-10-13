package programmers.Level0.solution._43_마지막_두_원소;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] num_list = { 2, 1, 6 };
        int[] expected = { 2, 1, 6, 5 };

        Solution solution = new Solution();
        int[] result = solution.solution(num_list);
        if (Arrays.equals(result, expected)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] num_list) {
        int size = num_list.length;
        int[] answer = new int[size + 1];
        for (int i = 0; i < size; i++) {
            answer[i] = num_list[i];
        }
        if (num_list[size - 2] < num_list[size - 1]) {
            answer[size] = num_list[size - 1] - num_list[size - 2];
        } else {
            answer[size] = num_list[size - 1] * 2;
        }
        return answer;
    }
}
