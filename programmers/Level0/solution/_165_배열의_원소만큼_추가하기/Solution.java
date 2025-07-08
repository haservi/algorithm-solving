package programmers.Level0.solution._165_배열의_원소만큼_추가하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181861?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = { 5, 1, 4 };
        int[] expectedResult = { 5, 5, 5, 5, 5, 1, 4, 4, 4, 4 };

        Solution solution = new Solution();
        int[] result = solution.solution(arr);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                answer.add(arr[i]);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
