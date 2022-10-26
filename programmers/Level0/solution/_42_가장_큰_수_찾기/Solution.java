package programmers.Level0.solution._42_가장_큰_수_찾기;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] array = { 1, 8, 3 };

        Solution solution = new Solution();
        int[] result = solution.solution(array);
        System.out.println("result: " + Arrays.toString(result));
    }

    public int[] solution(int[] array) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                index = i;
            }
        }

        int[] answer = new int[2];
        answer[0] = max;
        answer[1] = index;
        return answer;
    }
}
