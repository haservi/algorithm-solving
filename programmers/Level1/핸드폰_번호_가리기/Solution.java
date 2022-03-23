package programmers.Level1.핸드폰_번호_가리기;

class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    String num = "027778888";

    String result = solution.solution(num);
    System.out.println("결과 : " + result);
  }

  public String solution(String phone_number) {
    int startMaking = phone_number.length() - 4;
    String regex = "(?<=.{" + startMaking + "}).";
    phone_number = phone_number.replaceAll(regex, "*");
    return phone_number;
  }
}
