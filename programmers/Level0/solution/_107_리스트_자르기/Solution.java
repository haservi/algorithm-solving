package programmers.Level0.solution._107_리스트_자르기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181897?language=java
 */
class Solution {

    public static void main(String[] args) {
        int n = 3;
        int[] slicer = { 1, 5, 2 };
        int[] num_list = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] expectedResult = { 2, 3, 4, 5, 6 };

        Solution solution = new Solution();
        int[] result = solution.solution(n, slicer, num_list);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer;
        switch (n) {
            // 0번 인덱스부터 slicer[1]까지
            case 1 ->
                answer = Arrays.copyOfRange(num_list, 0, slicer[1] + 1);

            // slicer[0]부터 마지막 인덱스까지
            case 2 ->
                answer = Arrays.copyOfRange(num_list, slicer[0], num_list.length);

            // slicer[0]부터 slicer[1]까지
            case 3 ->
                answer = Arrays.copyOfRange(num_list, slicer[0], slicer[1] + 1);

            // slicer[0]부터 slicer[1]까지 slicer[2] 간격으로 선택
            case 4 -> {

                int start = slicer[0];
                int end = slicer[1];
                int step = slicer[2];

                int size = (end - start) / step + 1;
                answer = new int[size];
                int index = 0;

                for (int i = start; i <= end; i += step) {
                    answer[index++] = num_list[i];
                }
            }

            default -> answer = new int[0];
        }

        return answer;
    }

}
