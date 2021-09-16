package programmers.Level2.lv2_07_기능개발;

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] progresses = { 95, 90, 99, 99, 80, 99 };
    int[] speeds = { 1, 1, 1, 1, 1, 1 };

    int[] result = solution.solution(progresses, speeds);
    System.out.println("결과: " + Arrays.toString(result));
  }

  class Task {
    int progress;
    int speed;

    public Task (int progress, int speed) {
      this.progress = progress;
      this.speed = speed;
    }
  }

  public int[] solution(int[] progresses, int[] speeds) {

    Queue<Task> queue = new LinkedList<Task>();
    
    for (int i = 0; i < progresses.length; i++) {
      queue.add(new Task(progresses[i], speeds[i]));
    }
    int day = 1;
    int progressCompleteCount = 0;
    List<Integer> completeList = new ArrayList<Integer>();

    while (!queue.isEmpty()) {
      Task task = queue.peek();
      int score = task.progress + (task.speed * day);
      if (100 <= score) {
        queue.poll();
        progressCompleteCount++;
        // 가장 마지막 값 삽입
        if (queue.isEmpty()) {
          completeList.add(progressCompleteCount);
        }

      } else {
        if (progressCompleteCount != 0) {
          completeList.add(progressCompleteCount);
          progressCompleteCount = 0;
        }
        day++;
      }
    }
    // System.out.println(completeList.toString());
    return completeList.stream().mapToInt(i -> i).toArray();
  }
}
