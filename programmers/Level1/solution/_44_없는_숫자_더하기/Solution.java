package programmers.Level1.solution._44_없는_숫자_더하기;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86051
 */
public class Solution {

    public static void main(String[] args) {
        int[] numbers = { 5, 8, 4, 0, 6, 7, 9 };
        int expectedResult = 6;

        Solution solution = new Solution();
        int result = solution.solution2(numbers);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] numberIndexCheck = new boolean[10];

        for (int i = 0; i < numbers.length; i++) {
            int index = numbers[i];
            numberIndexCheck[index] = true;
        }

        for (int i = 0; i < 10; i++) {
            if (!numberIndexCheck[i])
                answer += i;
        }

        return answer;
    }

    public int solution2(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int v : numbers) {
            set.add(v);
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (set.contains(i)) {
                continue;
            }
            sum += i;
        }
        return sum;
    }

}
