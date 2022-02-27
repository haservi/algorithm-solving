package programmers.Level3.lv3_09_이중우선순위큐;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String[] operations = { "I 7", "I 5", "I -5", "D -1" };

    int[] result = solution.solution(operations);
    System.out.println("결과 : " + Arrays.toString(result));
  }

  public int[] solution(String[] operations) {

    int[] answer = new int[2];
    PriorityQueue<Integer> minPq = new PriorityQueue<>();
    PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < operations.length; i++) {
      String[] split = operations[i].split(" ");

      if (split[0].equals("I")) {
        minPq.add(Integer.parseInt(split[1]));
        maxPq.add(Integer.parseInt(split[1]));

      } else if (split[0].equals("D")) {
        if (!minPq.isEmpty()) {
          if (Integer.parseInt(split[1]) < 0) {
            int min = minPq.poll();
            maxPq.remove(min);
          } else {
            int max = maxPq.poll();
            minPq.remove(max);
          }
        }
      }
    }

    if (minPq.size() > 0) {
      answer[0] = maxPq.poll();
      answer[1] = minPq.poll();
    }

    return answer;
  }
}