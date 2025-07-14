package programmers.Level0.solution._166_빈_배열에_추가_삭제하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181860?language=java
 */
class Solution {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 1, 3 };
        boolean[] flag = { true, false, true, false, false };
        int[] expectedResult = { 3, 3, 3, 3, 4, 4, 4, 4 };

        Solution solution = new Solution();
        int[] result = solution.solution(arr, flag);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> answer = new ArrayList<>();
        int count = arr.length;

        for (int i = 0; i < count; i++) {
            if (flag[i]) {
                // 해당 수 만큼 list 추가
                for (int j = 0; j < arr[i]; j++) {
                    // 2배로 추가
                    answer.add(arr[i]);
                    answer.add(arr[i]);
                }
            } else {
                for (int j = 0; j < arr[i]; j++) {
                    answer.remove(answer.size() - 1);
                }
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
