package programmers.Level0.solution._163_그림_확대;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181836?language=java
 */
class Solution {

    public static void main(String[] args) {
        String[] picture = {
                "x.x",
                ".x.",
                "x.x"
        };
        int k = 3;

        String[] expectedResult = {
                "xxx...xxx",
                "xxx...xxx",
                "xxx...xxx",
                "...xxx...",
                "...xxx...",
                "...xxx...",
                "xxx...xxx",
                "xxx...xxx",
                "xxx...xxx"
        };

        Solution solution = new Solution();
        String[] result = solution.solution(picture, k);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        int idx = 0;
        for (String row : picture) {
            // 각 픽셀을 k번 반복하여 한 줄을 만듦
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < row.length(); j++) {
                char pixel = row.charAt(j);
                sb.append(String.valueOf(pixel).repeat(k));
            }

            String expandedRow = sb.toString();
            // 만들어진 한 줄을 k번 반복하여 세로로 확장
            for (int t = 0; t < k; t++) {
                answer[idx++] = expandedRow;
            }
        }
        return answer;
    }
}
