package programmers.Level3.solution._11_섬_연결하기;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42861?language=java
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
        int expectedResult = 4;

        Solution solution = new Solution();
        int result = solution.solution1(n, costs);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

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
        if (parent[node] == node) {
            return node;
        }
        return findParent(parent, parent[node]);
    }

    // -------------------------------------------------------------

    public int solution1(int n, int[][] costs) {
        Edge[] edges = Arrays.stream(costs)
                .map(edge -> new Edge(edge[0], edge[1], edge[2]))
                .sorted(Comparator.comparingInt(e -> e.cost))
                .toArray(Edge[]::new);

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }

        int totalCost = 0;
        for (Edge edge : edges) {
            Node node1 = nodes[edge.u];
            Node node2 = nodes[edge.v];

            if (node1.isConnected(node2)) {
                continue;
            }
            node1.merge(node2);
            totalCost += edge.cost;
        }

        return totalCost;
    }

    private static class Node {
        private int depth = 1;
        private Node parent = null;

        private boolean isConnected(Node node) {
            return root() == node.root();
        }

        private Node root() {
            if (parent == null) {
                return this;
            }
            return parent.root();
        }

        public void merge(Node node) {
            if (isConnected(node)) {
                return;
            }

            Node root1 = root();
            Node root2 = node.root();

            if (root1.depth > root2.depth) {
                root2.parent = root1;
            } else if (root1.depth < root2.depth) {
                root1.parent = root2;
            } else {
                root2.parent = root1;
                root1.depth += 1;
            }
        }
    }

    private static class Edge {
        private final int u;
        private final int v;
        private final int cost;

        private Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }
}
