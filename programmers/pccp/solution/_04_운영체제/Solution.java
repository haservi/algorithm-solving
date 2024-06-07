package programmers.pccp.solution._04_운영체제;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/15008/lessons/121686?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[][] program = { { 2, 0, 10 }, { 1, 5, 5 }, { 3, 5, 3 }, { 3, 12, 2 } };
        long[] expectedResult = { 20, 5, 0, 16, 0, 0, 0, 0, 0, 0, 0 };

        Solution solution = new Solution();
        long[] result = solution.solution(program);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public long[] solution(int[][] program) {

        Queue<Program> programs = Arrays.stream(program)
                .map(p -> new Program(p[0], p[1], p[2]))
                .sorted(Comparator.comparingInt(p -> p.calledAt))
                .collect(Collectors.toCollection(LinkedList::new));

        PriorityQueue<Program> pq = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) {
                return a.priority - b.priority;
            }
            return a.calledAt - b.calledAt;
        });

        long[] answer = new long[11];
        int time = 0;

        while (!programs.isEmpty() || !pq.isEmpty()) {
            while (!programs.isEmpty() && programs.peek().calledAt <= time) {
                pq.add(programs.poll());
            }

            if (pq.isEmpty()) {
                time = programs.peek().calledAt;
                continue;
            }

            Program p = pq.poll();
            answer[p.priority] += time - p.calledAt;
            time += p.executionTime;
        }
        answer[0] = time;
        return answer;
    }

    private static class Program {
        private final int priority;
        private final int calledAt;
        private final int executionTime;

        public Program(int priority, int calledAt, int executionTime) {
            this.priority = priority;
            this.calledAt = calledAt;
            this.executionTime = executionTime;
        }
    }
}
