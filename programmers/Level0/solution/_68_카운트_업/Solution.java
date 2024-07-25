package programmers.Level0.solution._68_카운트_업;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181920?language=java
 */
class Solution {

    public static void main(String[] args) {
        int l = 5;
        int r = 10;
        int[] expectedResult = { 5, 6, 7, 8, 9, 10 };

        Solution solution = new Solution();
        int[] result = solution.solution(l, r);
        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int start_num, int end_num) {
        List<Integer> answer = new ArrayList<>();
        for (int i = start_num; i <= end_num; i++) {
            answer.add(i);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(int start_num, int end_num) {
        return IntStream.rangeClosed(start_num, end_num).toArray();
    }
}
