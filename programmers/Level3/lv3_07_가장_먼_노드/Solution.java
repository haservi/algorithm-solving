package programmers.Level3.lv3_07_가장_먼_노드;

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
    return answer;
  }
}