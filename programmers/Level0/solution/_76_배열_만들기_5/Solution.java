package programmers.Level0.solution._76_배열_만들기_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181912?language=java
 */
class Solution {

    public static void main(String[] args) {
        String[] intStrs = { "0123456789", "9876543210", "9999999999999" };
        int k = 50000;
        int s = 5;
        int l = 5;

        int[] expectedResult = { 56789, 99999 };

        Solution solution = new Solution();
        int[] result = solution.solution(intStrs, k, s, l);
        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();

        for (String str : intStrs) {
            int num = Integer.parseInt(str.substring(s, s + l));

            if (num > k) {
                answer.add(num);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
