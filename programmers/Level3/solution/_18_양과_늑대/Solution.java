package programmers.Level3.solution._18_양과_늑대;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92343?language=java
 */
public class Solution {

    public static void main(String[] args) {
        int[] info = { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 };
        int[][] edges = {
                { 0, 1 }, { 1, 2 }, { 1, 4 },
                { 0, 8 }, { 8, 7 }, { 9, 10 },
                { 9, 11 }, { 4, 3 }, { 6, 5 },
                { 4, 6 }, { 8, 9 } };
        int expectedResult = 5;

        Solution solution = new Solution();
        int result = solution.solution(info, edges);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int[] info, int[][] edges) {
        boolean[][] tree = new boolean[info.length][info.length];
        for (int[] edge : edges) {
            tree[edge[0]][edge[1]] = true;
        }

        Set<Integer> nodes = new HashSet<>();
        nodes.add(0);

        return getMaxSheep(nodes, 0, 0, info, tree);
    }

    private int getMaxSheep(Set<Integer> nodes, int sheep, int wolf, int[] info, boolean[][] tree) {
        int maxSheep = sheep;

        for (int node : nodes) {
            int nextSheep = sheep;
            int nextWolf = wolf;

            if (info[node] == 0) {
                nextSheep += 1;
            } else {
                nextWolf += 1;
            }

            // 늑대가 같거나 큰 경우
            if (nextSheep <= nextWolf) {
                continue;
            }

            int s = getMaxSheep(getNextNodes(node, nodes, tree), nextSheep, nextWolf, info, tree);
            if (maxSheep < s) {
                maxSheep = s;
            }
        }
        return maxSheep;
    }

    private Set<Integer> getNextNodes(int node, Set<Integer> nodes, boolean[][] tree) {
        Set<Integer> nextNodes = new HashSet<>(nodes);
        nextNodes.remove(node);

        for (int next = 0; next < tree[node].length; next++) {
            if (!tree[node][next]) {
                continue;
            }
            nextNodes.add(next);
        }
        return nextNodes;
    }

}
