package programmers.Level2.solution._08_다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */
public class Solution {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = { 7, 4, 5, 6 };
        int expectedResult = 8;

        Solution solution = new Solution();
        int result = solution.solution(bridge_length, weight, truck_weights);

        if (result == expectedResult) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    /**
     * 1. 트럭이 모두 다리를 건너가야 하기 때문에 트럭의 횟수만큼 순회한다.
     * 2. 다리를 지날 때는 트럭큐를 이용하며, 시간을 계속 추가한다.
     * 3. 마지막 트럭의 경우 지나갈 때 다리의 길이만큼 시간을 소모하기 때문에 처음에 다리의 길이만큼 값을 더해준다.
     */
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

    public int solution2(int bridge_length, int weight, int[] truck_weights) {
        int bridgeWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int time = 0;
        int truckIndex = 0;
        while (truckIndex < truck_weights.length) {
            bridgeWeight -= bridge.poll();

            int truckWeight = truck_weights[truckIndex];
            if (bridgeWeight + truckWeight <= weight) {
                bridge.add(truckWeight);
                bridgeWeight += truckWeight;
                truckIndex++;
            } else {
                bridge.add(0);
            }

            time++;
        }

        while (bridgeWeight > 0) {
            bridgeWeight -= bridge.poll();
            time++;
        }

        return time;
    }
}
