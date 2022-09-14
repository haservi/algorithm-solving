package programmers.Level3.solution._11_섬_연결하기;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42861
 */
public class Solution {

    public static void main(String[] args) {

        int n = 4;
        int[][] costs = {
                { 0, 1, 1 },
                { 0, 2, 2 },
                { 1, 2, 5 },
                { 1, 3, 1 },
                { 2, 3, 8 }
        };

        Solution solution = new Solution();
        int result = solution.solution(n, costs);
        System.out.println("result: " + result);

    }

    public int solution(int n, int[][] costs) {

        // 가중치별로 오름차순 정렬
        Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        for (int i = 0; i < costs.length; i++) {
            int firstIsland = findParent(parent, costs[i][0]);
            int secondIsland = findParent(parent, costs[i][1]);
            if (firstIsland != secondIsland) {
                // 해당 인덱스를 부모로 정함(바꿔도 상관 없음)
                parent[secondIsland] = firstIsland;
                answer += costs[i][2];
            }
        }

        return answer;
    }

    private int findParent(int[] parent, int node) {
        if (parent[node] == node)
            return node;
        return findParent(parent, parent[node]);
    }
}
