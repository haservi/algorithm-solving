package programmers.Level3.solution._01_네트워크;

import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43162?language=java
 */
class Solution {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        };
        int expectedResult = 2;

        Solution solution = new Solution();
        int result = solution.solution1(n, computers);

        if (expectedResult == result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    /**
     * 1. 재귀적으로 반복하며 중복되는 네트워크를 찾는 함수를 실행한다.
     * 2. n:n의 경우는 항상 true이며 그렇지 않은경우 false로 네트워크를 상태를 확인한다.
     */
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                answer++;
                dfs(i, visited, computers);
            }
        }

        return answer;
    }

    private void dfs(int node, boolean[] visited, int[][] computers) {
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == false && computers[node][i] == 1) {
                dfs(i, visited, computers);
            }
        }
    }

    public int solution1(int n, int[][] computers) {
        boolean[] isVisited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (isVisited[i]) {
                continue;
            }
            visitAll(i, computers, isVisited);
            answer++;
        }

        return answer;
    }

    private void visitAll(int computer, int[][] computers, boolean[] isVisited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(computer);

        while (!stack.isEmpty()) {
            int c = stack.pop();

            if (isVisited[c]) {
                continue;
            }
            isVisited[c] = true;

            for (int next = 0; next < computers[c].length; next++) {
                if (computers[c][next] == 0) {
                    continue;
                }
                stack.push(next);
            }
        }
    }

}