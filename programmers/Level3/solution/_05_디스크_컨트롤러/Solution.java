package programmers.Level3.solution._05_디스크_컨트롤러;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */
class Solution {
    public static void main(String[] args) {
        int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
        int expectedResult = 9;

        Solution solution = new Solution();
        int result = solution.solution1(jobs);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
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

    public int solution1(int[][] jobData) {
        Job[] jobs = new Job[jobData.length];
        for (int i = 0; i < jobData.length; i++) {
            jobs[i] = new Job(jobData[i][0], jobData[i][1]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.start));

        // 요청 시간이 짧은 일감부터 정렬
        Queue<Job> q = new LinkedList<>(Arrays.asList(jobs));
        // 걸리는 시간이 짧은 일감부터 정렬
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(job -> job.duration));

        int exec = 0;
        int time = 0;
        while (!q.isEmpty() || !pq.isEmpty()) {
            while (!q.isEmpty() && q.peek().start <= time) {
                pq.add(q.poll());
            }

            if (pq.isEmpty()) {
                time = q.peek().start;
                continue;
            }

            Job job = pq.poll();
            exec += time + job.duration - job.start;
            time += job.duration;
        }
        return exec / jobs.length;
    }

    private static class Job {
        private final int start;
        private final int duration;

        private Job(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }
    }
}