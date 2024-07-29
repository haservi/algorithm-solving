package programmers.Level0.solution._70_배열_만들기_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181918?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 5, 3 };
        int[] expectedResult = { 1, 2, 3 };

        Solution solution = new Solution();
        int[] result = solution.solution(arr);
        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        int i = 0;

        while (i < arr.length) {
            if (stk.isEmpty() || stk.get(stk.size() - 1) < arr[i]) {
                stk.add(arr[i]);
                i++;
            } else {
                stk.remove(stk.size() - 1);
            }
        }

        return stk.stream().mapToInt(Integer::intValue).toArray();
    }

}
