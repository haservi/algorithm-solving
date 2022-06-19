package programmers.Level2.solution.타겟_넘버;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] numbers = { 1, 2, 3 };
    int target = 3;

    int result = solution.solution(numbers, target);
    System.out.println("결과: " + result);
  }

  public int solution(int[] numbers, int target) {
    int answer = dfs(0, 0, numbers, target);
    return answer;
  }

  private int dfs(int sum, int depth, int[] numbers, int target) {
    if (depth == numbers.length) {
      if (sum == target) {
        return 1;
      }
      return 0;
    }

    int plusSum = sum + numbers[depth];
    int minusSum = sum - numbers[depth];

    return dfs(plusSum, depth + 1, numbers, target) + dfs(minusSum, depth + 1, numbers, target);
  }
}
