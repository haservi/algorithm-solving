package programmers.Level3.Solution.정수_삼각형;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };

    int result = solution.solution(triangle);
    System.out.println("result : " + result);
  }

  public int solution(int[][] triangle) {

    int triangleDeath = triangle.length;
    int[][] dp = new int[triangleDeath][triangleDeath];

    // 가장 상단의 값을 가져옴
    dp[0][0] = triangle[0][0];

    // 삼각형은 1이상 500이하(triangle depth) 만큼 생성될 수 있음
    for (int i = 1; i < triangleDeath; i++) {

      // n번째 깊이의 값의 가장 좌측
      dp[i][0] = dp[i - 1][0] + triangle[i][0];

      // n번째 깊이의 j번째부터 값을 채움
      for (int j = 1; j < i + 1; j++) {
        // 처음 정의한 dp배열의 위쪽 값 2개를 비교하여 최대값을 넣음
        dp[i][j] = triangle[i][j] + (Math.max(dp[i - 1][j - 1], dp[i - 1][j]));
      }
    }

    int max = 0;
    for (int i = 0; i < triangleDeath; i++) {
      // 마지막의 dp배열 값들 중 가장 최대값을 선택
      max = Math.max(dp[triangleDeath - 1][i], max);
    }

    int answer = max;
    return answer;
  }
}