package programmers.Level2.solution._12_카펫;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
public class Solution {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        int[] expectedResult = { 8, 6 };

        Solution solution = new Solution();
        int[] result = solution.solution(brown, yellow);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int height = 0;
        int width = 0;
        // 전체 격자 개수
        int area = brown + yellow;

        for (int i = 3; i <= area; i++) {
            height = i;
            width = area / height;
            // 세로 길이가 긴 경우 다음으로 넘어감
            if (width < height) {
                continue;
            }

            int yellowCount = (width - 2) * (height - 2);
            if (yellowCount == yellow) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }
        return answer;
    }

    public int[] solution2(int brown, int yellow) {
        for (int width = 3; width <= 5000; width++) {
            for (int height = 3; height <= width; height++) {
                int boundary = (width + height - 2) * 2;
                int center = width * height - boundary;
                // 계속해서 탐색하면서 매개변수의 값과 일치하면 값을 return
                if (brown == boundary && yellow == center) {
                    return new int[] { width, height };
                }
            }
        }
        return null;
    }

}
