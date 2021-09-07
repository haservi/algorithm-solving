package programmers.Level1.lv1_47_하샤드_수;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int num = 11;

    boolean result = solution.solution(num);
    System.out.println("결과 : " + result);
  }

  public boolean solution(int x) {
    int sum = 0;
    int num = x;

    // 자릿수의 합
    while (num != 0) {
      sum += num % 10;
      num /= 10;
    }

    // 나머지가 0이면 하샤드 수라고 판단
    if (x % sum == 0)
      return true;
    else
      return false;
  }
}
