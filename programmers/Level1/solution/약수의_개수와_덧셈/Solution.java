package programmers.Level1.solution.약수의_개수와_덧셈;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int result = solution.solution(24, 27);
    System.out.println("결과 : " + result);
  }

  public int solution(int left, int right) {
    int answer = 0;
    for (int i = left; i <= right; i++) {
      // 소수를 구한뒤 짝수이면 더하고 홀수이면 뺀다.
      if (isFactorOfEven(getNumberOfFactors(i))) {
        answer = answer + i;
      } else {
        answer = answer - i;
      }
    }
    return answer;
  }

  private int getNumberOfFactors(int num) {
    int factorCount = 0;

    for (int i = 1; i <= num; i++) {
      if (num % i == 0) {
        factorCount++;
      }
    }
    // System.out.println("수 : " + num + ", 기댓값 : " + factorCount);
    return factorCount;
  }

  private boolean isFactorOfEven(int num) {
    if (num % 2 == 0) {
      return true;
    } else {
      return false;
    }
  }

}
