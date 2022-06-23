package programmers.Level3.solution._05_디스크_컨트롤러;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };

        int result = solution.solution(jobs);
        System.out.println("결과 : " + result);
    }

    public int solution(int[][] jobs) {
        int time = 0;
        int jobEndTime = 0;
        int jobIndex = 0;
        int count = 0;

        // 원본 배열 오름차순 정렬 (요청시간 오름차순)
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 처리 시간 오름차순으로 정렬되는 우선순위 큐(Heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while (count < jobs.length) {

            while (jobIndex < jobs.length && jobs[jobIndex][0] <= jobEndTime) {
                pq.add(jobs[jobIndex++]);
            }

            if (pq.isEmpty()) {
                jobEndTime = jobs[jobIndex][0];

            } else {
                // PriorityQueue에 정의된 요청시간이 가장 짧은 값을 가져옴
                int[] temp = pq.poll();
                time += ((jobEndTime - temp[0]) + temp[1]);
                jobEndTime += temp[1];
                count++;
            }
        }

        return time / jobs.length;
    }
}