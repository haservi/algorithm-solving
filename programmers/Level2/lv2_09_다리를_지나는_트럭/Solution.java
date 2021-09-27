package programmers.Level2.lv2_09_다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int bridge_length = 2;
    int weight = 10;
    int[] truck_weights = { 7, 4, 5, 6 };
    int result = solution.solution(bridge_length, weight, truck_weights);
    System.out.println("결과: " + result);
  }

  public int solution(int bridge_length, int weight, int[] truck_weights) {

    Queue<Integer> truckQueue = new LinkedList<Integer>();

    int time = bridge_length;
    int bridgeOnTruckWeight = 0;
    for (Integer truckWeight : truck_weights) {
      while (true) {
        if (truckQueue.isEmpty()) {
          truckQueue.add(truckWeight);
          bridgeOnTruckWeight += truckWeight;
          time++;
          break;
        } else if (truckQueue.size() == bridge_length) {
          bridgeOnTruckWeight -= truckQueue.poll();
        } else {
          time++;
          if ((bridgeOnTruckWeight + truckWeight) <= weight) {
            truckQueue.add(truckWeight);
            bridgeOnTruckWeight += truckWeight;
            break;
          } else {
            truckQueue.add(0);
          }
        }
      }
    }
    return time;
  }
}
