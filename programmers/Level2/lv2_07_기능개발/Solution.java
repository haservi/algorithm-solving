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

  public int[] solution(int[] progresses, int[] speeds) {
    Queue<Integer> queue = new LinkedList<Integer>();
    Queue<Integer> speedQueue = new LinkedList<Integer>();
    for (int i = 0; i < progresses.length; i++) {
      queue.offer(progresses[i]);
      speedQueue.offer(speeds[i]);
    }
    int day = 1;
    int dayComplete = 0;
    List<Integer> completeList = new ArrayList<Integer>();
    while (!queue.isEmpty()) {
      int score = queue.peek() + (speedQueue.peek() * day);
      if (100 <= score) {
        queue.poll();
        speedQueue.poll();
        dayComplete++;
        // 가장 마지막 값 삽입
        if (queue.isEmpty()) {
          completeList.add(dayComplete);
        }

      } else {
        if (dayComplete != 0) {
          completeList.add(dayComplete);
          dayComplete = 0;
        }
        day++;
      }
    }
    // System.out.println(completeList.toString());
    return completeList.stream().mapToInt(i -> i).toArray();
  }
}
