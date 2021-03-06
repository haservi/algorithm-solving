package programmers.Level2.solution._07_프린터;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. Queue를 이용하여 현재 값이 작은 경우 뒤로 다시 붙이기를 반복한다.
 * 2. 값이 큰 경우는 붙이지 않고 location의 위치와 일치하는지 확인하며 해당 로직을 반복한다.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] priorities = { 2, 1, 3, 2 };
        int location = 2;
        int result = solution.solution(priorities, location);
        System.out.println("결과: " + result);
    }

    class Task {
        int location;
        int priority;

        public Task(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Task> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Task(i, priorities[i]));
        }

        int now = 0;
        while (!queue.isEmpty()) {
            Task current = queue.poll();
            boolean flag = false;

            for (Task t : queue) {
                if (current.priority < t.priority) {
                    flag = true;
                }
            }

            if (flag) {
                queue.add(current);
            } else {
                now++;
                if (current.location == location) {
                    answer = now;
                    break;
                }
            }
        }
        return answer;
    }
}
