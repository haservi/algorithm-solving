package programmers.Level3.네트워크;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int n = 3;
    int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }; // 2
    int[][] computers1 = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } }; // 1
    int result = solution.solution(n, computers);
    System.out.println("결과 : " + result);
  }

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
}