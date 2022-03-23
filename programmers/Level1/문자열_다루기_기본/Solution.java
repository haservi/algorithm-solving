package programmers.Level1.문자열_다루기_기본;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String s = "132234";

    boolean result = solution.solution(s);
    System.out.println("결과 : " + result);
  }

  public boolean solution(String s) {
    boolean answer = true;
    String regex = "^[0-9]{4}$|^[0-9]{6}$";
    if (s.matches(regex)) {
      answer = true;
    } else {
      answer = false;
    }
    return answer;
  }
}
