package programmers.Level3.lv3_07_가장_먼_노드;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int n = 6;
    int[][] vertex = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

    long result = solution.solution(n, vertex);
    System.out.println("결과 : " + result);
  }

  public int solution(int n, int[][] edge) {
    int answer = 0;

    boolean[] visited = new boolean[n + 1];
    boolean[][] graph = new boolean[n + 1][n + 1];

    // 양방향으로 그래프를 매핑
    for (int[] connect : edge) {
      graph[connect[0]][connect[1]] = true;
      graph[connect[1]][connect[0]] = true;
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.add(1); // 1부터 시작
    visited[1] = true; // 현재 방문 위치

    while (!queue.isEmpty()) {
      System.out.println("queue size: " + queue.size());
      
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        int now = queue.poll();
        
        for (int j = 1; j <= n; j++) {
          // 연결된 node에서 추가적으로 연결된 부분이 있는지 확인
          if (!visited[j] && graph[now][j]) {
            visited[j] = true;
            queue.add(j);
          }
        }
      }
      answer = queueSize;
    }
    return answer;
  }
}