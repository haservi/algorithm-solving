package programmers.Level2.solution._11_H_INDEX;

import java.util.Arrays;

/**
 * 1. 총 논문의 수 중 해당 논문의 인용한 값의 최대값을 구하는 문제이다.
 * 2. 정렬한 뒤에 전체 길이만큼 순회하면서 인용횟수가 크거나 같은 경우를 찾으면 H-Index값을 구할 수 있다.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] citations = { 1, 1, 2, 3, 4 };
        int result = solution.solution(citations);
        System.out.println("결과: " + result);
    }

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
}
