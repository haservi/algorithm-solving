package programmers.Level2.solution._14_큰수_만들기;

import java.util.*;
import java.util.stream.*;

/**
 * 
 */
public class Solution {
    public static void main(String[] args) {
        String number = "1924";
        int k = 2;
        String expectedResult = "94";

        Solution solution = new Solution();
        String result = solution.solution1(number, k);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    /**
     * 모든 숫자 중 가장 큰 값의 순서대로 정의
     */
    public String solution(String number, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        int max = 0;
        int count = number.length() - k;

        // k가 정의한 횟수만큼 전체 순회
        for (int i = 0; i < count; i++) {
            max = 0;
            for (int j = index; j <= k + i; j++) {
                // 해당 number의 가장 큰 값을 저장
                if (max < (number.charAt(j) - '0')) {
                    max = (number.charAt(j) - '0');
                    index = j + 1;
                }
            }
            stringBuilder.append(max);
        }
        return stringBuilder.toString();
    }

    public String solution1(String number, int k) {
        Stack<Character> stack = new Stack<Character>();

        char[] charArray = number.toCharArray();

        for (char c : charArray) {
            // 더 넣을 수가 남아 있으면서 스택이 비어있지 않은 상태에서 다음 나온 수와 비교
            while (k > 0 && !stack.isEmpty() && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (k-- > 0) {
            stack.pop();
        }

        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
