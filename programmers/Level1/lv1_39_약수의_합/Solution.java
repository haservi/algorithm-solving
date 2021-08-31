package programmers.Level1.lv1_39_약수의_합;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int n = 1000;

    int result = solution.solution(n);
    System.out.println("결과 : " + result);
  }

  public int solution(int n) {
    int answer = 0;
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        answer += i;
      }
    }
    return answer;
  }
}
