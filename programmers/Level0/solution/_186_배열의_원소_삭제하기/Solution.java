package programmers.Level0.solution._186_배열의_원소_삭제하기;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181844?language=java
 */
class Solution {

    public static void main(String[] args) {
        int[] arr = {293, 1000, 395, 678, 94};
        int[] delete_list = {94, 777, 104, 1000, 1, 12};
        int[] expectedResult = {293, 395, 678};

        Solution solution = new Solution();
        int[] result = solution.solution(arr, delete_list);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[] arr, int[] delete_list) {
        Set<Integer> deleteSet = new HashSet<>();
        for (int num : delete_list) {
            deleteSet.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : arr) {
            if (!deleteSet.contains(num)) {
                result.add(num);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
