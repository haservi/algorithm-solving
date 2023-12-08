package programmers.Level2.solution._11_H_INDEX;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class Solution {
    public static void main(String[] args) {
        int[] citations = { 3, 0, 6, 1, 5 };
        int expectedResult = 3;

        Solution solution = new Solution();
        int result = solution.solution2(citations);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    /**
     * 정렬한 뒤에 전체 길이만큼 순회하면서 인용횟수가 크거나 같은 경우
     */
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int hIndex = citations.length - i;

            if (citations[i] >= hIndex) {
                answer = hIndex;
                break;
            }
        }
        return answer;
    }

    public int solution2(int[] citations) {
        Arrays.sort(citations);
        for (int h = citations.length; h >= 1; h--) {
            if (isValid(citations, h)) {
                return h;
            }
        }
        return 0;
    }

    private boolean isValid(int[] citations, int h) {
        int index = citations.length - h;
        return citations[index] >= h;
    }

}
