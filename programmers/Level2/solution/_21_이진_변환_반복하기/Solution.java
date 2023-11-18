package programmers.Level2.solution._21_이진_변환_반복하기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
public class Solution {

    public static void main(String[] args) {

        String s = "110010101001";
        Solution solution = new Solution();
        int[] result = solution.solution(s);
        System.out.println("result: " + Arrays.toString(result));
    }

    public int[] solution(String s) {
        int[] answer = new int[2];

        while (s.length() > 1) {
            int length = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    answer[1]++;
                } else {
                    length++;
                }
            }
            s = toBinary(length);
            // s = Integer.toBinaryString(length);
            answer[0]++;
        }
        return answer;
    }

    private String toBinary(int decimal) {
        StringBuilder result = new StringBuilder();
        int binary[] = new int[40];
        int index = 0;
        while (decimal > 0) {
            binary[index++] = decimal % 2;
            decimal = decimal / 2;
        }
        for (int i = index - 1; i >= 0; i--) {
            result.append(binary[i]);
        }
        return result.toString();
    }
}
