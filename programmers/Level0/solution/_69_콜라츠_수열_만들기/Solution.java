package programmers.Level0.solution._69_콜라츠_수열_만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181919?language=java
 */
class Solution {

    public static void main(String[] args) {
        int n = 10;
        int[] expectedResult = { 10, 5, 16, 8, 4, 2, 1 };

        Solution solution = new Solution();
        int[] result = solution.solution(n);
        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        answer.add(n);
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (3 * n) + 1;
            }
            answer.add(n);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
