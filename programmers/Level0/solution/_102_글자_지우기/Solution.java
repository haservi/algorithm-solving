package programmers.Level0.solution._102_글자_지우기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181900?language=java
 */
class Solution {

    public static void main(String[] args) {
        String my_string = "apporoograpemmemprs";
        int[] indices = { 1, 16, 6, 15, 0, 10, 11, 3 };
        String expectedResult = "programmers";

        Solution solution = new Solution();
        String result = solution.solution(my_string, indices);

        if (expectedResult.equals(result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public String solution(String my_string, int[] indices) {
        StringBuilder answer = new StringBuilder();

        Arrays.sort(indices);

        int indexPointer = 0;
        int indicesLength = indices.length;

        for (int i = 0; i < my_string.length(); i++) {
            // 제외 인덱스에 해당하면 건너뜀
            if (indexPointer < indicesLength && i == indices[indexPointer]) {
                indexPointer++;
            } else {
                answer.append(my_string.charAt(i));
            }
        }

        return answer.toString();
    }
}
