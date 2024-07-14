package programmers.Level0.solution._62_순서_바꾸기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181891?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] num_list = { 5, 2, 1, 7, 5 };
        int n = 3;
        int[] expectedResult = { 7, 5, 5, 2, 1 };

        Solution solution = new Solution();
        int[] result = solution.solution(num_list, n);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] num_list, int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = n; i < num_list.length; i++) {
            answer.add(num_list[i]);
        }
        int index = 0;
        while (0 < n) {
            answer.add(num_list[index]);
            n--;
            index++;
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public int[] solution1(int[] num_list, int n) {
        int length = num_list.length;
        int[] answer = new int[length];
        System.arraycopy(num_list, n, answer, 0, length - n);
        System.arraycopy(num_list, 0, answer, length - n, n);
        return answer;
    }
}
