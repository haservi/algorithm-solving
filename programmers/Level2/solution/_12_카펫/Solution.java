package programmers.Level2.solution._12_카펫;

import java.util.Arrays;

/**
 * 1. 최소 세로길이 3부터 순차적으로 돌면서 내부 사각형의 격자의 개수와 일치하는지 확인하면 된다.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int brown = 24;
        int yellow = 24;
        int[] result = solution.solution(brown, yellow);
        System.out.println("결과: " + Arrays.toString(result));
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

}
