package programmers.Level1.solution._47_같은_숫자는_싫어;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 */
public class Solution {

    public static void main(String[] args) {

        int[] arr = { 1, 1, 3, 3, 0, 1, 1 };

        Solution solution = new Solution();
        int[] result = solution.solution(arr);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int temp = -1;
        for (int i : arr) {
            if (temp != i) {
                list.add(i);
            }
            temp = i;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

}
