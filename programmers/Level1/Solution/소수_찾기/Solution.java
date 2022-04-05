package programmers.Level1.Solution.소수_찾기;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int n = 10;

    int result = solution.solution(n);
    System.out.println("결과 : " + result);
  }

  public int solution(int n) {
    int answer = 0;
    
    for (int i = 1; i <= n; i++) {
      if (isPrime(i)) {
        answer++;
      }
    }
    return answer;
  }

  private boolean isPrime(int num) {
    if (num <= 1) {
      return false;
    }
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0)
        return false;
    }
    return true;
  }
}
