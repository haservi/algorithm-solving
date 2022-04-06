package programmers.Level2.Solution.프린터;

import java.util.LinkedList;
import java.util.Queue;

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
