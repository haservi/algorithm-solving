package programmers.Level2.solution._27_연속된_부분_수열의_합;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] sequence = { 1, 1, 1, 2, 3, 4, 5 };
        int k = 5;
        int[] expected = { 6, 6 };

        Solution solution = new Solution();
        int[] result = solution.solution(sequence, k);

        if (Arrays.equals(expected, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int sum = 0;
        int size = sequence.length;
        int left = 0;
        int right = 0;
        int leftAnswer = 0;
        int rightAnswer = 0;

        while (right < sequence.length) {
            sum += sequence[right];

            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                int currentSize = right - left;
                if (currentSize < size) {
                    size = currentSize;
                    leftAnswer = left;
                    rightAnswer = right;
                } else if (currentSize == size) {
                    leftAnswer = Math.min(leftAnswer, left);
                    rightAnswer = Math.min(rightAnswer, right);
                }
            }
            right++;
        }

        answer[0] = leftAnswer;
        answer[1] = rightAnswer;
        return answer;
    }

}
