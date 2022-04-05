package programmers.Level1.Solution.콜라츠_추측;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    int num = 626331;

    int result = solution.solution(num);
    System.out.println("결과 : " + result);
  }

  public int solution(long num) {
    int answer = 0;
    while (num != 1) {
      if (num % 2 == 0) {
        num = num / 2;
      } else {
        num = (num * 3) + 1;
      }
      answer++;
      if (answer == 500) {
        return -1;
      }
    }
    return answer;
  }
}
