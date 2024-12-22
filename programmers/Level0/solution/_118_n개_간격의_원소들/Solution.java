package programmers.Level0.solution._118_n개_간격의_원소들;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181888?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] num_list = { 4, 2, 6, 1, 7, 6 };
        int n = 2;
        int[] expectedResult = { 4, 6, 7 };

        Solution solution = new Solution();
        int[] result = solution.solution(num_list, n);

        if (Arrays.equals(result, expectedResult)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] num_list, int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < num_list.length; i++) {
            if (i % n == 0) {
                answer.add(num_list[i]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * ArrayList와 변환 과정을 제거하여 메모리 사용량 감소
     */
    public int[] solution1(int[] num_list, int n) {
        int size = (num_list.length + n - 1) / n;
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            answer[i] = num_list[i * n];
        }

        return answer;
    }

}
