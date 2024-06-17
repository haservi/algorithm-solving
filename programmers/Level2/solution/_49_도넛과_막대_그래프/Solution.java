package programmers.Level2.solution._49_도넛과_막대_그래프;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/258711?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[][] edges = { { 2, 3 }, { 4, 3 }, { 1, 1 }, { 2, 1 } };
        int[] expectedResult = { 2, 1, 1, 0 };

        Solution solution = new Solution();
        int[] result = solution.solution(edges);

        if (Arrays.equals(expectedResult, result)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int[] solution(int[][] edges) {
        Map<Integer, int[]> nodeCnt = new HashMap<>();
        // [point, donut, bar, 8]
        int[] answer = new int[4];

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            nodeCnt.putIfAbsent(a, new int[2]);
            nodeCnt.putIfAbsent(b, new int[2]);

            nodeCnt.get(a)[0] += 1;
            nodeCnt.get(b)[1] += 1;
        }

        for (Map.Entry<Integer, int[]> entry : nodeCnt.entrySet()) {
            int key = entry.getKey();
            int[] counts = entry.getValue();
            int outDegree = counts[0];
            int inDegree = counts[1];

            if (inDegree == 0 && outDegree >= 2) {
                answer[0] = key; // Point node
            } else if (outDegree == 0 && inDegree > 0) {
                answer[2]++; // Bar node
            } else if (outDegree >= 2 && inDegree >= 2) {
                answer[3]++; // 8 node
            }
        }

        if (nodeCnt.containsKey(answer[0])) {
            int pointOutDegree = nodeCnt.get(answer[0])[0];
            answer[1] = pointOutDegree - answer[2] - answer[3]; // Donut nodes count
        }

        return answer;
    }
}
