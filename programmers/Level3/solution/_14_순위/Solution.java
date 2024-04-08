package programmers.Level3.solution._14_순위;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49191
 */
public class Solution {

    public static void main(String[] args) {
        int n = 6;
        int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 }, { 6, 2 } };
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution(n, results);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n][n];
        for (int[] edge : results) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u][v] = true;
        }

        int count = 0;
        for (int u = 0; u < n; u++) {
            int wins = countForward(u, graph, new boolean[n]) - 1;
            int loses = countBackward(u, graph, new boolean[n]) - 1;
            // 해당 선수가 이긴 횟수와 진 횟수에 자신을 더한 경우 결과를 알 수 있음
            if (wins + loses + 1 == n) {
                System.out.println("user:" + (u + 1) + " win:" + wins + " loses: " + loses + " rank: " + (loses + 1));
                count++;
            }
        }
        return count;
    }

    private int countForward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for (int v = 0; v < graph[u].length; v++) {
            if (!graph[u][v] || isVisited[v]) {
                continue;
            }
            isVisited[v] = true;
            count += countForward(v, graph, isVisited);
        }
        return count;
    }

    private int countBackward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for (int v = 0; v < graph.length; v++) {
            if (!graph[v][u] || isVisited[v]) {
                continue;
            }
            isVisited[v] = true;
            count += countBackward(v, graph, isVisited);
        }
        return count;
    }

}
