package programmers.Level2.solution._09_더_맵게;

import java.util.PriorityQueue;

/**
 * 1. 가장 작은 값과 다음으로 작은 값을 이용하여 스코빌 값을 만든 후 음식 스코빌에 추가한다.
 * 2. 음식 스코빌에서 가장 작은 값과 스코빌 지수를 비교하여 충족하지 못한 경우 1을 반복 수행하면 된다.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        int K = 7;
        int result = solution.solution(scoville, K);
        System.out.println("결과: " + result);
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int value : scoville) {
            heap.add(value);
        }

        int smallValue = 0;
        // 해당 스코빌 지수보다 높아질 때까지 반복
        while (smallValue < K) {
            // 더이상 만들수 없는 경우
            if (heap.size() < 2) {
                return -1;
            }
            answer++;
            heap.add(makeScoville(heap.poll(), heap.poll()));
            smallValue = heap.peek();
        }

        return answer;
    }

    /**
     * 스코빌 지수 계산 함수
     * 
     * @param num1 가장 맵지 않은 음식의 스코빌 지수
     * @param num2 두 번째로 맵지 않은 음식의 스코빌 지수
     * @return
     */
    private int makeScoville(int num1, int num2) {
        return num1 + (num2 * 2);
    }
}
